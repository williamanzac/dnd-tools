define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	function ChooseRaceStep() {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Race");
		self.view("ChooseRaceStep");
		self.complete(false);
		self.i18n = ko.observable(new I18n(self.model));

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};
		
		self.setRace = function(race) {
			self.model().race(race);
			self.complete(true);
		};
		
		self.raceSelected = function(race) {
			return self.model().race() !== undefined && race.name === self.model().race().name;
		};

		self.races = ko.observableArray([]);
		$.getJSON("/races", function(data) {
			self.races(data);
		});
	}
	
	ChooseRaceStep.prototype = Object.create(WizardStep.prototype);
	ChooseRaceStep.prototype.constructor = ChooseRaceStep;

	return ChooseRaceStep;
});