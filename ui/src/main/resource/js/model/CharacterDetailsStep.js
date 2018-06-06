define([ 'jquery', 'knockout', '../model/WizardStep' ], function($, ko, WizardStep) {
	function CharacterDetailsStep(i18n) {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Character Details");
		self.view("CharacterDetailsStep");
		self.detailPanels = ko.observableArray();
		self.complete(false);
		self.i18n = ko.observable(i18n);
		
		self.init = function(model) {
			self.model(ko.unwrap(model));
		};

		self.refreshState = function() {
			var complete = true;
			self.detailPanels().forEach(function(t) {
				if (!t.complete()) {
					complete = false;
				}
			});
			self.complete(complete);
		};
		
		self.addDetailPanel = function(detailPanel) {
			if (detailPanel === undefined || detailPanel.complete === undefined) {
				return;
			}
			detailPanel.complete.subscribe(self.refreshState);
			self.detailPanels.push(detailPanel);
		};
	}
	
	CharacterDetailsStep.prototype = Object.create(WizardStep.prototype);
	CharacterDetailsStep.prototype.constructor = CharacterDetailsStep;

	return CharacterDetailsStep;
});