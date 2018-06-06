define([ 'jquery', 'knockout', '../model/WizardStep' ], function($, ko, WizardStep) {
	function RaceTraitsStep(i18n) {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Racial Traits");
		self.view("RaceTraitsStep");
		self.complete(false);
		self.traitPanels = ko.observableArray();
		self.i18n = ko.observable(i18n);

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
		
		self.addTraitPanel = function(traitPanel) {
			if (traitPanel === undefined || traitPanel.complete === undefined) {
				return;
			}
			traitPanel.complete.subscribe(self.refreshState);
			self.traitPanels.push(traitPanel);
		}
	}
	
	RaceTraitsStep.prototype = Object.create(WizardStep.prototype);
	RaceTraitsStep.prototype.constructor = RaceTraitsStep;

	return RaceTraitsStep;
});