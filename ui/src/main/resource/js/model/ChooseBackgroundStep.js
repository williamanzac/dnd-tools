define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	function ChooseBackgroundStep() {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Background");
		self.view("ChooseBackgroundStep");
		self.complete(false);
		self.i18n = ko.observable(new I18n(self.model));

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};

		self.applyState = function() {
			if (self.model().background().skillProficiencies.numberSkillProficiencies == 0 && self.model().background().skillProficiencies.proficientSkills.length > 0) {
				var racialSkills = self.model().racialSkills();
				var classSkills = self.model().classSkills();
				self.model().background().skillProficiencies.proficientSkills.forEach(function(skill) {
					racialSkills = racialSkills.filter(s => s !== skill.name);
					classSkills = classSkills.filter(s => s !== skill.name);
				});
				self.model().racialSkills(racialSkills);
				self.model().classSkills(classSkills);
			}
		};

		self.setBackground = function(background) {
			self.model().background(background);
			self.complete(true);
		};
		
		self.backgroundSelected = function(background) {
			return self.model().background() !== undefined && background.name === self.model().background().name;
		};

		self.backgrounds = ko.observableArray([]);
		$.getJSON("/backgrounds", function(data) {
			self.backgrounds(data);
		});
	}
	
	ChooseBackgroundStep.prototype = Object.create(WizardStep.prototype);
	ChooseBackgroundStep.prototype.constructor = ChooseBackgroundStep;

	return ChooseBackgroundStep;
});