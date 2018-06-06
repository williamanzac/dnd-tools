define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	
	function ProficenciesFeature() {
		var self = this;
		
		self.name = "Proficiencies";
	};

	function CharacteristicsFeature() {
		var self = this;
		
		self.name = "Characteristics";
	};

	function ChooseBackgroundStep(i18n) {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Background");
		self.view("ChooseBackgroundStep");
		self.complete(false);
		self.i18n = ko.observable(i18n);
		self.featurePanels = ko.observableArray();
		self.proficenciesFeature = ko.observable(new ProficenciesFeature());
		self.characteristicsFeature = ko.observable(new CharacteristicsFeature());

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

		self.refreshState = function() {
			var complete = true;
			self.featurePanels().forEach(function(t) {
				if (!t.complete()) {
					complete = false;
				}
			});
			self.complete(complete);
		};
		
		self.addFeaturePanel = function(featurePanel) {
			if (featurePanel === undefined || featurePanel.complete === undefined) {
				return;
			}
			featurePanel.complete.subscribe(self.refreshState);
			self.featurePanels.push(featurePanel);
		};

		self.setBackground = function(background) {
			self.model().background(background);
			//self.complete(true);
		};
		
		self.backgroundSelected = function(background) {
			return self.model().background() !== undefined && background.name === self.model().background().name;
		};

		self.backgrounds = ko.observableArray([]);
		$.getJSON("/backgrounds", function(data) {
			self.backgrounds(data);
		});
		
		self.refreshState();
	}
	
	ChooseBackgroundStep.prototype = Object.create(WizardStep.prototype);
	ChooseBackgroundStep.prototype.constructor = ChooseBackgroundStep;

	return ChooseBackgroundStep;
});