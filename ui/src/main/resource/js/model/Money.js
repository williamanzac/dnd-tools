define([ 'jquery', 'knockout' ], function($, ko) {
	function Money() {
		var self = this;
		self.platinum = ko.observable(0);
		self.gold = ko.observable(0);
		self.electrum = ko.observable(0);
		self.silver = ko.observable(0);
		self.copper = ko.observable(0);
	}
	
	return Money;
});