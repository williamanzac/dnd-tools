define([ 'jquery', 'knockout', '../model/WizardStep' ], function($, ko, WizardStep) {
	
	function ProficenciesFeature() {
		var self = this;
		
		self.name = "Proficiencies";
	}
	
	function HitPointsFeature() {
		var self = this;
		
		self.name = "HitPoints";
	}
	
	function ClassFeaturesStep(i18n) {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Class Features");
		self.view("ClassFeaturesStep");
		self.complete(false);
		self.featurePanels = ko.observableArray();
		self.classLevel = ko.observable();
		self.hitPointsFeature = ko.observable(new HitPointsFeature());
		self.proficenciesFeature = ko.observable(new ProficenciesFeature());
		self.i18n = ko.observable(i18n);

		self.init = function(model) {
			self.model(ko.unwrap(model));
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
	
	ClassFeaturesStep.prototype = Object.create(WizardStep.prototype);
	ClassFeaturesStep.prototype.constructor = ClassFeaturesStep;

	return ClassFeaturesStep;
});