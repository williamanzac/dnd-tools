define([ 'jquery', 'knockout', '../model/StaticModel' ], function($, ko,
        StaticModel) {

	function CharacterBuilderModel() {
		StaticModel.call(this);

		var self = this;
		self.race = ko.observable();
		self.racialModifiers = ko.observableArray([]);
		self.racialLanguages = ko.observableArray([]);
		self.racialSkills = ko.observableArray([]);
		self.age = ko.observable();
		self.height = ko.observable();
		self.weight = ko.observable();
		self.characterClass = ko.observable();
		self.characterLevel = ko.observable(1);
		self.classSkills = ko.observableArray([]);
		self.abilityScores = ko.observableArray([]);
		self.background = ko.observable();
		self.backgroundSkills = ko.observableArray([]);
		self.backgroundLanguages = ko.observableArray([]);
		self.personalityTrait = ko.observable();
		self.ideal = ko.observable();
		self.bond = ko.observable();
		self.flaw = ko.observable();
		self.name = ko.observable();
		self.alignment = ko.observable();
		self.faith = ko.observable();
		self.lifestyle = ko.observable();
		self.hair = ko.observable();
		self.skin = ko.observable();
		self.eyes = ko.observable();
		self.gender = ko.observable();
		self.organisations = ko.observable();
		self.allies = ko.observable();
		self.enemies = ko.observable();
		self.backstory = ko.observable();
		self.other = ko.observable();
		self.startingWealth = ko.observable();
		self.equipment = ko.observableArray();

		self.getAbilityScoreModifier = function(ability) {
			return Math.floor((self.getAbilityScore(ability) - 10) / 2);
		};

		self.getAbilityScore = function(ability) {
			var score = self.abilityScores()[ability]();
			if (score === undefined) {
				score = 0;
			}
			score *= 1;

			if (self.race() != undefined && self.race().abilityMods[ability] != undefined) {
				score += self.race().abilityMods[ability] * 1;
			}
			var index = self.racialModifiers.indexOf(ability);
			if (index >= 0) {
				score += 1;
			}
			return score;
		};
		
		$.getJSON("/abilities", function(abilities) {
			abilities.forEach(function(ability) {
				var abilities = self.abilityScores();
				if (abilities[ability] === undefined) {
					abilities[ability] = ko.observable(0);
					self.abilityScores(abilities);
				}
			});
		});
	}

	CharacterBuilderModel.prototype = Object.create(StaticModel.prototype);
	CharacterBuilderModel.prototype.constructor = CharacterBuilderModel;

	return CharacterBuilderModel;
});
