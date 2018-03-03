define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	function ChooseClassStep() {
		WizardStep.call(this);
		var self = this;
		
		self.model = ko.observable();
		self.name("Choose Class");
		self.view("ChooseClassStep");
		self.complete(false);
		self.i18n = ko.observable(new I18n(self.model));

		self.init = function(model) {
			self.model(ko.unwrap(model));
		};
		
		self.setClass = function(c) {
			self.model().characterClass(c);
			self.complete(true);
		};
		
		self.classSelected = function(c) {
			return self.model().characterClass() !== undefined && c.name === self.model().characterClass().name;
		};

		self.classes = ko.observableArray([]);
		$.getJSON("/classes", function(data) {
			self.classes(data);
		});
	}
	
	ChooseClassStep.prototype = Object.create(WizardStep.prototype);
	ChooseClassStep.prototype.constructor = ChooseClassStep;

	return ChooseClassStep;
});