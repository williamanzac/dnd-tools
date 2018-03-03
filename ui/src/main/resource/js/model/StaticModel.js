define([ 'jquery', 'knockout', '../model/WizardModel', '../model/WizardStep' ], function($, ko,
        WizardModel, WizardStep) {

	function StaticModel() {
		WizardModel.call(this);

		var self = this;
		
		self.steps = new Array();
		self.currentStep = 0;

		self.reset = function() {
			self.currentStep = 0;
			self.activeStep(self.steps[self.currentStep]);
		};

		self.nextStep = function() {
			if (self.currentStep >= self.steps.length - 1) {
				throw "Already on last step";
			}
			
			self.currentStep++;
			self.activeStep(self.steps[self.currentStep]);
		};

		self.previousStep = function() {
			if (self.currentStep == 0) {
				throw "Already at first step";
			}
			
			self.currentStep--;
			self.activeStep(self.steps[self.currentStep]);
		};

		self.lastStep = function() {
			self.currentStep = self.steps.length - 1;
			self.activeStep(self.steps[self.currentStep]);
		};

		self.isLastStep = function(step) {
			return self.steps.indexOf(step) == self.steps.length - 1;
		};

		self.stepIterator = function() {
			return self.steps;
		};

		self.add = function(step) {
			self.steps.push(step);
			self.addCompleteListener(step);
		};

		self.refreshModelState = function() {
			if (self.activeStep() === undefined) {
				return;
			}
			self.nextAvailable(self.activeStep().complete() && !self.isLastStep(self.activeStep()));
			self.previousAvailable(self.currentStep > 0);
			self.lastAvailable(self.allStepsComplete() && !self.isLastStep(self.activeStep()));
			self.cancelAvailable(true);
		};

		self.allStepsComplete = function() {
			for (i=0; i < self.steps.length; i++) {
				if (!self.steps[i].complete()) {
					return false;
				}
			}
			
			return true;
		};

		
        self.activeStep.subscribe(self.refreshModelState);
	}

	StaticModel.prototype = Object.create(WizardModel.prototype);
	StaticModel.prototype.constructor = StaticModel;

	return StaticModel;
});
