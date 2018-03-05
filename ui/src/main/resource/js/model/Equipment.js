define([ 'jquery', 'knockout', '../model/CharacterItem' ], function($, ko, CharacterItem) {
	function Equipment() {
		var self = this;
		self.items = ko.observableArray();
		self.keys = ko.pureComputed(function() {
			var k = [];
			self.items().forEach(function(item) {
				var name = item.item().name;
				k.push(name);
			});
			return k;
		});
		
		self.getItemByName = function(name) {
			var found;
			self.items().forEach(function(item) {
				if (item.item().name == name) {
					found = item;
				}
			});
			return found;
		};
		
		self.addItem = function(item, startingEquipment) {
			var name = item.name;
			var k = self.keys();
			var i = self.items();
			if (k.indexOf(name) < 0) {
				self.items.push(new CharacterItem(item, 1, startingEquipment));
			} else {
				var chItem = self.getItemByName(name);
				var q = chItem.quantity();
				q *= 1;
				chItem.quantity(q + 1);
			}
		};
		
		self.clear = function() {
			self.items([]);
		};
	}
	
	return Equipment;
});