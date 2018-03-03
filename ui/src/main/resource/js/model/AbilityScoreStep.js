define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {

	function Mode(name) {
		var self = this;
		
		self.name = ko.observable(name);
		self.generate = function(step) {
			
		};
	}

	function StandardMode() {
		Mode.call(this, 'Standard');
		var self = this;
		
		self.generate = function(step) {
			var numbers = [15, 14, 13, 12, 10, 8];
			for (i = 0; i < numbers.length; i++) {
				var ability = step.abilities()[i];
				var value = numbers[i];
				step.model().abilityScores()[ability](value);
			}
		};
	}

	StandardMode.prototype = Object.create(Mode.prototype);
	StandardMode.prototype.constructor = StandardMode;

	function DiceRollMode() {
		Mode.call(this, 'Dice Roll');
		var self = this;
		
		self.generate = function(step) {
			$.ajax({
				method : "POST",
				url : "/abilities/generateScores",
				contentType : "application/json"
			}).done(function(numbers) {
				for (i = 0; i < numbers.length; i++) {
					var ability = step.abilities()[i];
					var value = numbers[i];
					step.model().abilityScores()[ability](value);
				}
			});
		};
	}

	DiceRollMode.prototype = Object.create(Mode.prototype);
	DiceRollMode.prototype.constructor = DiceRollMode;

	function PointBuyMode() {
		Mode.call(this, 'Point Buy');
		var self = this;
		self.availablePoints = ko.observable(27);
		self.pointCosts = [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 7, 9];
		
		self.generate = function(step) {
			var numbers = [8, 8, 8, 8, 8, 8];
			for (i = 0; i < numbers.length; i++) {
				var ability = step.abilities()[i];
				var value = numbers[i];
				step.model().abilityScores()[ability](value);
			}
			self.availablePoints(27);
		};
	}

	PointBuyMode.prototype = Object.create(Mode.prototype);
	PointBuyMode.prototype.constructor = PointBuyMode;

	function AbilityScorceStep() {
		WizardStep.call(this);
		var self = this;
		
		self.abilities = ko.observableArray();
		self.modes = ko.observableArray([new StandardMode(), new DiceRollMode(), new PointBuyMode(), new Mode("Manual")]);
		self.currentMode = ko.observable();
		self.i18n = ko.observable(new I18n(self.model));
		
		self.model = ko.observable();
		self.name("Ability Scores");
		self.view("AbilityScoreStep");
		self.complete(false);

		self.init = function(model) {
			self.model(ko.unwrap(model));
			self.selectMode(self.modes()[0]);
		};
		
		self.selectMode = function(mode) {
			if (self.currentMode() === mode) {
				return;
			}
			self.currentMode(mode);
			mode.generate(self);
			var name = self.currentMode().name();
			if (name === 'Standard' || name === 'Dice Roll' || name === 'Manual') {
				self.complete(true);
			} else {
				self.complete(false);
			}
		};
		
		self.moveLeft = function(index) {
			var indexA = self.abilities()[index];
			var indexB = self.abilities()[index - 1];
			self.swapScores(indexA, indexB);
		};
		
		self.moveRight = function(index) {
			var indexA = self.abilities()[index];
			var indexB = self.abilities()[index + 1];
			self.swapScores(indexA, indexB);
		};

		self.swapScores = function(indexA, indexB) {
			var abilityScores = self.model().abilityScores();
			var tmp = abilityScores[indexA];
			abilityScores[indexA] = abilityScores[indexB];
			abilityScores[indexB] = tmp;
			self.model().abilityScores(abilityScores);
		};
		
		self.decreaseScore = function(ability) {
			var currentScore = self.model().abilityScores()[ability]();
			currentScore *= 1;
			var currentTotal = self.model().getAbilityScore(ability);
			currentTotal *= 1;
			if ((currentScore <= 8 && self.currentMode().name() === 'Point Buy') || currentTotal <= 1) {
				return;
			}
			var newScore = currentScore - 1;
			if (newScore < 1) {
				return;
			}
			if (self.currentMode().name() === 'Point Buy') {
				var diff = self.pointDifference(currentScore, newScore);
				var points = self.currentMode().availablePoints();
				points += diff;
				self.currentMode().availablePoints(points);
				self.complete(points === 0);
			}
			self.model().abilityScores()[ability](newScore);
		};

		self.pointDifference = function(currentScore, newScore) {
			var currentCost = self.currentMode().pointCosts[currentScore];
			var newCost = self.currentMode().pointCosts[newScore];
			var diff = currentCost - newCost;
			return diff;
		};
		
		self.increaseScore = function(ability) {
			var currentScore = self.model().abilityScores()[ability]();
			currentScore *= 1;
			var currentTotal = self.model().getAbilityScore(ability);
			currentTotal *= 1;
			if ((currentScore >= 15 && self.currentMode().name() === 'Point Buy') || currentTotal >= 20) {
				return;
			}
			var newScore = currentScore + 1;
			if (newScore > 20) {
				return;
			}
			if (self.currentMode().name() === 'Point Buy') {
				var diff = self.pointDifference(currentScore, newScore);
				var points = self.currentMode().availablePoints();
				points += diff;
				self.currentMode().availablePoints(points);
				self.complete(points === 0);
			}
			self.model().abilityScores()[ability](newScore);
		};
		
		self.canDecrease = function(ability) {
			var currentScore = self.model().abilityScores()[ability]();
			currentScore *= 1;
			var currentTotal = self.model().getAbilityScore(ability);
			currentTotal *= 1;
			if ((currentScore <= 8 && self.currentMode().name() === 'Point Buy') || currentTotal <= 1) {
				return false;
			}
			var newScore = currentScore - 1;
			if (self.currentMode().name() === 'Point Buy') {
				var diff = self.pointDifference(currentScore, newScore);
				var points = self.currentMode().availablePoints();
				points += diff;
				return points >= 0;
			}
			return newScore >= 1;
		};
		
		self.canIncrease = function(ability) {
			var currentScore = self.model().abilityScores()[ability]();
			currentScore *= 1;
			var currentTotal = self.model().getAbilityScore(ability);
			currentTotal *= 1;
			if ((currentScore >= 15 && self.currentMode().name() === 'Point Buy') || currentTotal >= 20) {
				return false;
			}
			var newScore = currentScore + 1;
			if (self.currentMode().name() === 'Point Buy') {
				var diff = self.pointDifference(currentScore, newScore);
				var points = self.currentMode().availablePoints();
				points += diff;
				return points >= 0;
			}
			return newScore <= 20;
		};

		$.getJSON("/abilities", function(data) {
			self.abilities(data);
		});
	}

	AbilityScorceStep.prototype = Object.create(WizardStep.prototype);
	AbilityScorceStep.prototype.constructor = AbilityScorceStep;

	return AbilityScorceStep;
});