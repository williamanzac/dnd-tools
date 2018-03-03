define([ 'jquery', 'knockout' ], function($, ko) {
	function Path() {
		var self = this;
		self.steps = new Array();

		self.getNextPath = function(model) {
		}
		
		self.addStep = function(step) {
			self.steps.push(step);
		}
		
		self.firstStep = function() {
			return self.steps[0];
		}
		
		self.nextStep = function(currentStep) {
			var index = self.steps.indexOf(currentStep);
			return self.steps[index + 1];
		}
		
		self.previousStep = function(currentStep) {
			var index = self.steps.indexOf(currentStep);
			return self.steps[index - 1];
		}
		
		self.lastStep = function() {
			return self.steps[self.steps.length - 1];
		}
		
		self.isFirstStep = function(step) {
			return self.steps.indexOf(step) == 0;
		}
		
		self.isLastStep = function(step) {
			var lastStep = self.steps.lastIndexOf(step) == self.steps.length - 1;
			return lastStep;
		}
		
		self.contains = function(step) {
			return self.steps.contains(step);
		}
		
		self.acceptVisitor = function(visitor) {
		}
	}
	
	return Path;
});