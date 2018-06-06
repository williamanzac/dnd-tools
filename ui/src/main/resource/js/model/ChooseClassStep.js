define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	
	function ProficenciesFeature() {
		var self = this;
		
		self.name = "Proficiencies";
	}
	
	function HitPointsFeature() {
		var self = this;
		
		self.name = "HitPoints";
	}
	
	function ChooseClassStep(i18n) {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Class");
		self.view("ChooseClassStep");
		self.complete(false);
		self.i18n = ko.observable(i18n);
		self.featurePanels = ko.observableArray();
		self.classLevel = ko.observable();
		self.hitPointsFeature = ko.observable(new HitPointsFeature());
		self.proficenciesFeature = ko.observable(new ProficenciesFeature());

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};
		
		self.setClass = function(c) {
			self.model().characterClass(c);
			//self.complete(true);
		};
		
		self.classSelected = function(c) {
			return self.model().characterClass() !== undefined && c.name === self.model().characterClass().name;
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

		self.classes = ko.observableArray([]);
		$.getJSON("/classes", function(data) {
			self.classes(data);
		});
		
		self.refreshState();
	}
	
	ChooseClassStep.prototype = Object.create(WizardStep.prototype);
	ChooseClassStep.prototype.constructor = ChooseClassStep;

	return ChooseClassStep;
});