define([ 'jquery', 'knockout' ], function($, ko) {
	function PathVisitor() {
		var self = this;
		self.paths = new Array();

		self.visitPath = function(path) {
		}
		
		self.enter = function(path) {
			return self.paths.push(path);
		}
	}
	
	return PathVisitor;
});