define(
        [ 'jquery', 'knockout', '../model/WizardModel', '../model/PathVisitor', '../model/BranchingPath',
                '../model/Map' ], function($, ko, WizardModel, PathVisitor, BranchingPath, Map) {

	        function LastPathVisitor() {
		        PathVisitor.call(this);

		        var self = this;

		        self.last = null;

		        self.visitPath = function(p) {
			        if (BranchingPath.prototype.isPrototypeOf(p)) {
				        if (self.enter(p)) {
					        p.visitBranches(self);
				        }
			        } else {
				        if (self.enter(p)) {
					        if (p.getNextPath() == null) {
						        if (self.last != null) {
							        throw new IllegalStateException("Two paths have empty values for nextPath");
						        }
						        self.last = p;
					        } else {
						        p.visitNextPath(self);
					        }
				        }
			        }
		        }

		        self.getPath = function() {
			        return self.last;
		        }
	        }

	        LastPathVisitor.prototype = Object.create(PathVisitor.prototype);
	        LastPathVisitor.prototype.constructor = LastPathVisitor;

	        function PathMapVisitor() {
		        PathVisitor.call(this);

		        var self = this;

		        self.map = new Map();

		        self.visitPath = function(p) {
			        if (BranchingPath.prototype.isPrototypeOf(p)) {
				        if (self.enter(p)) {
					        self.populateMap(p);
					        p.visitBranches(this);
				        }
			        } else {
				        if (self.enter(p)) {
					        self.populateMap(p);
					        p.visitNextPath(self);
				        }
			        }
		        }

		        self.populateMap = function(path) {
			        path.steps.forEach(function(step) {
				        self.map.put(step, path);
			        });
		        }
	        }

	        PathMapVisitor.prototype = Object.create(PathVisitor.prototype);
	        PathMapVisitor.prototype.constructor = PathMapVisitor;

	        function MultiPathModel(firstPath) {
		        WizardModel.call(this);

		        var self = this;

		        self.firstPath = firstPath;
		        self.history = new Array();

		        var visitor = new PathMapVisitor();
		        firstPath.acceptVisitor(visitor);
		        self.pathMapping = visitor.map;

		        visitor = new LastPathVisitor();
		        firstPath.acceptVisitor(visitor);
		        self.lastPath = visitor.getPath();

		        if (self.lastPath == null) {
			        throw "Unable to locate last path";
		        }

		        self.pathMapping.keys.forEach(function(step) {
			        self.addCompleteListener(step);
		        });

		        self.nextStep = function() {
			        var currentStep = self.activeStep();
			        var currentPath = self.getPathForStep(currentStep);

			        if (currentPath.isLastStep(currentStep)) {
				        var nextPath = currentPath.getNextPath(self);
				        self.activeStep(nextPath.firstStep());
			        } else {
				        self.activeStep(currentPath.nextStep(currentStep));
			        }

			        self.history.push(currentStep);
		        };

		        self.previousStep = function() {
			        var step = self.history.pop();
			        self.activeStep(step);
		        };

		        self.lastStep = function() {
			        self.history.push(self.activeStep());
			        var lastStep = self.lastPath.lastStep();
			        self.activeStep(lastStep);
		        };

		        self.reset = function() {
			        self.history = new Array();
			        var firstStep = self.firstPath.firstStep();
			        self.activeStep(firstStep);
			        self.history.push(firstStep);
		        };

		        self.isLastStep = function(step) {
			        var path = self.getPathForStep(step);
			        return path == self.lastPath && path.isLastStep(step);
		        };

		        self.refreshModelState = function() {
			        var activeStep = self.activeStep();
			        var activePath = self.getPathForStep(activeStep);

			        self.nextAvailable(activeStep.complete() && !self.isLastStep(activeStep));
			        self.previousAvailable(!(activePath == self.firstPath && activePath.isFirstStep(activeStep)));
			        self.lastAvailable(self.allStepsComplete() && !self.isLastStep(activeStep));
			        self.cancelAvailable(true);
		        };

		        self.allStepsComplete = function() {
			        var complete = true;
			        self.stepIterator().forEach(function(step) {
				        if (!step.complete()) {
					        complete = false;
				        }
			        });
			        return complete;
		        };

		        self.stepIterator = function() {
			        return self.pathMapping.keys;
		        };

		        self.getPathForStep = function(step) {
			        return self.pathMapping.get(step);
		        }

		        self.activeStep.subscribe(self.refreshModelState);
	        }

	        MultiPathModel.prototype = Object.create(WizardModel.prototype);
	        MultiPathModel.prototype.constructor = MultiPathModel;

	        return MultiPathModel;
        });
