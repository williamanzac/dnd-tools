define([ 'jquery', 'knockout', '../model/Path', '../model/Condition' ], function($, ko, Path, Condition) {
	function BranchingPath(step) {
		Path.call(this);
		var self = this;
		
		self.paths = new Array();
		
		if (step !== undefined) {
			self.addStep(step);
		}
		
		self.getNextPath = function(model) {
			Object.keys(self.paths).forEach(function(condition) {
				if (condition.evaluate(model)) {
					return self.paths[condition];
				}
			});
			
			throw new IllegalStateException("No next path selected");
		}
		
		self.addBranch = function(path, condition) {
			self.paths[condition] = path;
		}
		
		self.acceptVisitor = function(visitor) {
			visitor.visitPath(self);
		}
		
		self.visitBranches = function(visitor) {
			self.paths.forEach(function(path) {
				path.acceptVisitor(visitor);
			});
		}
	}
	
	BranchingPath.prototype = Object.create(Path.prototype);
	BranchingPath.prototype.constructor = BranchingPath;

	return BranchingPath;
});