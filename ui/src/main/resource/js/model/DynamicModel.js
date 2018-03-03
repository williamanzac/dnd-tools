define([ 'jquery', 'knockout', '../model/WizardModel', '../model/WizardStep', '../model/Condition' ], function($, ko,
        WizardModel, WizardStep, Condition) {

	var TRUE_CONDITION = new Condition();
	TRUE_CONDITION.evaluate = function(model) {
		return true;
	};

	function DynamicModel() {
		WizardModel.call(this);

		var self = this;
		self.steps = new Array();
		self.conditions = new Array();

		self.history = new Array();

		self.add = function(step, condition) {
			if (condition === undefined) {
				// only step passed in
				if (Condition.prototype.isPrototypeOf(step)) {
					condition = step;
				} else {
					condition = TRUE_CONDITION;
				}
			}

			self.addCompleteListener(step);
			self.steps.push(step);
			self.conditions.push(condition);
		};

		self.nextStep = function() {
			var currentStep = self.activeStep();
			self.history.push(currentStep);
			self.activeStep(self.findNextVisibleStep(currentStep));
		};

		self.previousStep = function() {
			var step = self.history.pop();
			self.activeStep(step);
		};

		self.lastStep = function() {
			var activeStep = self.activeStep();
			self.history.push(activeStep);
			self.activeStep(self.findLastStep());
		};

		self.reset = function() {
			self.history = new Array();
			self.activeStep(self.findNextVisibleStep(null));
		};

		self.isLastStep = function(step) {
			return self.findLastStep() == step;
		};

		self.refreshModelState = function() {
			var activeStep = self.activeStep();
			self.nextAvailable(activeStep != null && activeStep.complete() && !self.isLastStep(activeStep));
			self.previousAvailable(activeStep != null && self.history.length != 0);
			self.lastAvailable(activeStep != null && self.allStepsComplete() && !self.isLastStep(activeStep));
			self.cancelAvailable(true);
		};

		self.allStepsComplete = function() {
			for (i = 0; i < self.steps.length; i++) {
				var step = self.steps[i];
				var condition = self.conditions[i];

				if (condition.evaluate(self)) {
					if (!step.complete()) {
						return false;
					}
				}
			}

			return true;
		};

		self.stepIterator = function() {
			return self.steps;
		};

		self.findNextVisibleStep = function(currentStep) {
			var startIndex = (currentStep === undefined || currentStep === null) ? 0
			        : self.steps.indexOf(currentStep) + 1;

			for (i = startIndex; i < self.conditions.length; i++) {
				var condition = self.conditions[i];
				if (condition.evaluate(self)) {
					return self.steps[i];
				}
			}

			throw "Wizard contains no more visible steps";
		};

		self.findLastStep = function() {
			for (i = self.conditions.length - 1; i >= 0; i--) {
				var condition = self.conditions[i];
				if (condition.evaluate(self)) {
					return self.steps[i];
				}
			}

			throw "Wizard contains no visible steps";
		};

        self.activeStep.subscribe(self.refreshModelState);
	}

	DynamicModel.prototype = Object.create(WizardModel.prototype);
	DynamicModel.prototype.constructor = DynamicModel;

	return DynamicModel;
});
