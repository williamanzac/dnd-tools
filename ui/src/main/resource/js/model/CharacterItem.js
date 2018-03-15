define([ 'jquery', 'knockout' ], function($, ko) {
	function CharacterItem(item, quantity, startingEquipment) {
		var self = this;
		self.item = ko.observable(item);
		self.quantity = ko.observable(quantity);
		self.startingQuantity = ko.observable(quantity);
		self.equipped = ko.observable(false);
		self.startingEquipment = ko.observable(startingEquipment || false);
		self.expanded = ko.observable(false);

		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};
	}
	
	return CharacterItem;
});