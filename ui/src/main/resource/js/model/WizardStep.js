define([ 'jquery', 'knockout' ], function($, ko) {
	function WizardModel(view) {
		var self = this;

		self.name = ko.observable();

		self.summary = ko.observable();

		self.icon = ko.observable();

		self.view = ko.observable(view);

		self.complete = ko.observable(true);

		self.busy = ko.observable(false);

		self.init = function(model) {
		};

		self.prepare = function() {
		};

		self.applyState = function() {
		};
		
		self.abortBusy = function() {
		};
	}
	
	return WizardModel;
});