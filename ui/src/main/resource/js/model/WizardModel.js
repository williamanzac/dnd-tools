define([ 'jquery', 'knockout' ], function($, ko) {
	function WizardModel() {
		var self = this;
		self.activeStep = ko.observable();
		self.previousAvailable = ko.observable();
		self.nextAvailable = ko.observable();
		self.lastAvailable = ko.observable();
		self.cancelAvailable = ko.observable();
		self.lastVisible = ko.observable(true);

		self.nextStep = function() {
		};

		self.previousStep = function() {
		};

		self.lastStep = function() {
		};

		self.reset = function() {
		};

		self.isLastStep = function(step) {
		};

		self.stepIterator = function() {
		};

		self.refreshModelState = function() {
		};
		
		self.addCompleteListener = function(step) {
			if (step === undefined || step.complete === undefined) {
				return;
			}
			step.complete.subscribe(self.refreshModelState);
		}
	}

	return WizardModel;
});