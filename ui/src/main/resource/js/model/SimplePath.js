define([ 'jquery', 'knockout', '../model/Path' ], function($, ko, Path) {
	function SimplePath(step) {
		Path.call(this);
		var self = this;
		
		self.nextPath;
		
		if (step !== undefined) {
			self.addStep(step);
		}

		self.acceptVisitor = function(visitor) {
			visitor.visitPath(self);
		}

		self.visitNextPath = function(visitor) {
			if (self.nextPath !== undefined) {
				self.nextPath.acceptVisitor(visitor);
			}
		}
	}
	
	return SimplePath;
});