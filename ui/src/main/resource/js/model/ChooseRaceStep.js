define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	function ChooseRaceStep() {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Race");
		self.view("ChooseRaceStep");
		self.complete(false);
		self.i18n = ko.observable(new I18n(self.model));
		self.traitPanels = ko.observableArray();

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};

		self.refreshState = function() {
			var complete = true;
			self.traitPanels().forEach(function(t){
				if (!t.complete()) {
					complete = false;
				}
			});
			self.complete(complete);
		}
		
		self.setRace = function(race) {
			self.model().race(race);
			//self.complete(true);
		};
		
		self.raceSelected = function(race) {
			return self.model().race() !== undefined && race.name === self.model().race().name;
		};
		
		self.addTraitPanel = function(traitPanel) {
			if (traitPanel === undefined || traitPanel.complete === undefined) {
				return;
			}
			traitPanel.complete.subscribe(self.refreshState);
			self.traitPanels.push(traitPanel);
		}

		self.races = ko.observableArray([]);
		$.getJSON("/races", function(data) {
			self.races(data);
		});
		
		self.refreshState();
	}
	
	ChooseRaceStep.prototype = Object.create(WizardStep.prototype);
	ChooseRaceStep.prototype.constructor = ChooseRaceStep;

	return ChooseRaceStep;
});