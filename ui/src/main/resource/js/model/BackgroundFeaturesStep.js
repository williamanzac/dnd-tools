define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	
	function ProficenciesFeature() {
		var self = this;
		
		self.name = "Proficiencies";
	};

	function CharacteristicsFeature() {
		var self = this;
		
		self.name = "Characteristics";
	};
	
	function BackgroundFeaturesStep() {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Background Features");
		self.view("BackgroundFeaturesStep");
		self.complete(false);
		self.featurePanels = ko.observableArray();
		self.i18n = ko.observable();
		self.proficenciesFeature = ko.observable(new ProficenciesFeature());
		self.characteristicsFeature = ko.observable(new CharacteristicsFeature());

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};

		self.prepare = function() {
			self.i18n(new I18n(self.model));
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
		
		self.refreshState();
	}
	
	BackgroundFeaturesStep.prototype = Object.create(WizardStep.prototype);
	BackgroundFeaturesStep.prototype.constructor = BackgroundFeaturesStep;

	return BackgroundFeaturesStep;
});