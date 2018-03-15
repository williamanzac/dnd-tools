define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n', '../model/CharacterItem' ], function($, ko, WizardStep, I18n, CharacterItem) {
	
	function StartingEquipmentComplete() {
		var complete = true;
		this.options.forEach(function(item) {
			if (!item.complete()) {
				complete = false;
			}
		});
		return complete;
	};
	
	function EquipmentOptionComplete() {
		var self = this;
		if (this.numberOfChoices == 0) {
			return true;
		}
		if (this.numberOfChoices > 0 && this.items.length > 0) {
			var numSelected = 0;
			this.items.forEach(function(item) {
				if (self.selectedItems.indexOf(item.name) >= 0) {
					numSelected++;
				}
			});
			return numSelected == this.numberOfChoices;
		}
		if (this.numberOfChoices > 0 && this.options.length > 0) {
			var numSelected = 0;
			var complete = true;
			this.options.forEach(function(item) {
				if (self.selectedOptions.indexOf(item.name) >= 0) {
					numSelected++;
					if (!item.complete()) {
						complete = false;
					}
				}
			});
			return complete && numSelected == this.numberOfChoices;
		}
		return false;
	};
	
	function EquipmentStep() {
		WizardStep.call(this);
		var self = this;

		self.model = ko.observable();
		self.name("Equipment");
		self.view("EquipmentStep");
		self.complete(false);
		self.i18n = ko.observable();
		self.startingWealth = ko.observable();
		self.gear = ko.observableArray();
		self.armour = ko.observableArray();
		self.weapons = ko.observableArray();
		self.packs = ko.observableArray();

		self.modes = ko.observableArray(["StartingEquipment", "Gold"]);
		self.addItemModes = ko.observableArray(["Gear", "Armour", "Weapons", "Packs"]);
		self.currentMode = ko.observable();
		self.currentAddItemMode = ko.observable();
		self.startingExpanded = ko.observable(false);
		self.equipmentExpanded = ko.observable(false);
		self.moneyExpanded = ko.observable(false);
		self.addEquipmentExpanded = ko.observable(false);

		self.toggleStartingExpanded = function() {
			self.startingExpanded(!self.startingExpanded());
		};
		self.toggleEquipmentExpanded = function() {
			self.equipmentExpanded(!self.equipmentExpanded());
		};
		self.toggleMoneyExpanded = function() {
			self.moneyExpanded(!self.moneyExpanded());
		};
		self.toggleAddEquipmentExpanded = function() {
			self.addEquipmentExpanded(!self.addEquipmentExpanded());
		};

		self.init = function(model) {
			self.model(ko.unwrap(model));
			self.i18n(new I18n(self.model));
			self.startingWealth.subscribe(self.updateComplete);

			self.model().characterClass().startingEquipment.complete = ko.pureComputed(StartingEquipmentComplete, self.model().characterClass().startingEquipment);
			self.model().characterClass().startingEquipment.options.forEach(function(option) {
				option.selectedOptions = ko.observableArray();
				option.selectedItems = ko.observableArray();
				option.complete = ko.pureComputed(EquipmentOptionComplete, option);
				option.options.forEach(function(o) {
					o.selectedItems = ko.observableArray();
					o.complete = ko.pureComputed(EquipmentOptionComplete, o);
				});
			});
			self.model().characterClass().startingEquipment.complete.subscribe(self.updateComplete);

			self.model().background().startingEquipment.complete = ko.pureComputed(StartingEquipmentComplete, self.model().background().startingEquipment);
			self.model().background().startingEquipment.options.forEach(function(option) {
				option.selectedOptions = ko.observableArray();
				option.selectedItems = ko.observableArray();
				option.complete = ko.pureComputed(EquipmentOptionComplete, option);
				option.options.forEach(function(o) {
					o.selectedItems = ko.observableArray();
					o.complete = ko.pureComputed(EquipmentOptionComplete, o);
				});
			});
			self.model().background().startingEquipment.complete.subscribe(self.updateComplete);
		};

		self.addOptionItems = function(option) {
			if (option.numberOfChoices == 0 && option.items.length > 0) {
				option.items.forEach(function(item) {
					self.model().equipment().addItem(item, true);
				})
			}
			if (option.numberOfChoices > 0 && option.items.length > 0) {
				option.items.forEach(function(item) {
					if (option.selectedItems.indexOf(item.name) >= 0) {
						self.model().equipment().addItem(item, true);
					}
				});
			}
			if (option.numberOfChoices > 0 && option.options.length > 0) {
				option.options.forEach(function(item) {
					if (option.selectedOptions.indexOf(item.name) >= 0) {
						self.addOptionItems(item);
					}
				});
			}
		};

		self.updateComplete = function() {
			self.model().equipment().clear();
			if (self.currentMode() == 'Gold') {
				self.model().money().gold(self.startingWealth());
				self.complete(self.startingWealth() > 0);
			}
			if (self.currentMode() == 'StartingEquipment') {
				self.model().characterClass().startingEquipment.options.forEach(self.addOptionItems);
				self.model().background().startingEquipment.options.forEach(self.addOptionItems);
				self.model().money().gold(self.model().background().money.gold);
				self.complete(self.model().characterClass().startingEquipment.complete() && self.model().background().startingEquipment.complete());
			}
		};
		
		self.selectMode = function(mode) {
			if (self.currentMode() === mode) {
				return;
			}
			self.currentMode(mode);
			self.updateComplete();
		};
		
		self.selectAddItemMode = function(mode) {
			if (self.currentAddItemMode() === mode) {
				return;
			}
			self.currentAddItemMode(mode);
		};
		
		self.modeSelected = function(mode) {
			return self.currentMode() === mode;
		};
		
		self.addItemModeSelected = function(mode) {
			return self.currentAddItemMode() === mode;
		};
		
		self.toggleOption = function(option, parent) {
			var numSelected = 0;
			parent.options.forEach(function(o) {
				if (self.optionSelected(o, parent)) {
					numSelected++;
				}
			});
			if (self.optionSelected(option, parent)) {
				parent.selectedOptions.remove(option.name);
			} else if (numSelected >= parent.numberOfChoices) {
				parent.selectedOptions.shift();
				parent.selectedOptions.push(option.name);
			} else {
				parent.selectedOptions.push(option.name);
			}
		};

		self.selectItem = function(item, option) {
			var numSelected = 0;
			option.items.forEach(function(i) {
				if (self.itemSelected(i, option)) {
					numSelected++;
				}
			});
			if (self.itemSelected(item, option)) {
				option.selectedItems.remove(item.name);
			} else if (numSelected >= option.numberOfChoices) {
				return;
			} else {
				option.selectedItems.push(item.name);
			}
		};

		self.optionSelected = function(option, parent) {
			return parent.selectedOptions.indexOf(option.name) >= 0;
		};

		self.itemSelected = function(item, option) {
			return option.selectedItems.indexOf(item.name) >= 0;
		};

		self.optionDisabled = function(option, parent) {
			var numSelected = 0;
			parent.options.forEach(function(o) {
				if (self.optionSelected(o, parent)) {
					numSelected++;
				}
			});
			return !self.optionSelected(option, parent) && numSelected >= parent.numberOfChoices;
		};
		
		self.generateStartingWealth = function() {
			var data = ko.toJS(self.model().characterClass().startingWealth);
			$.ajax({
				method : "POST",
				url : "/builder/startingWealth",
				contentType : "application/json",
				dataType : "json",
				data: JSON.stringify(data)
			}).done(function(money) {
				self.startingWealth(money.gold);
			});
		};

		self.addItem = function(item) {
			var gold = self.model().money().gold();
			if (gold - item.item().cost < 0) {
				return;
			}
			self.model().equipment().addItem(item.item());
			gold -= item.item().cost;
			self.model().money().gold(gold);
		};
		
		self.canAddItem = function(item) {
			var gold = self.model().money().gold();
			gold *= 1;
			gold -= item.item().cost;
			return gold >= 0;
		};

		self.removeItem = function(item) {
			var gold = self.model().money().gold();
			gold *= 1;
			self.model().equipment().removeItem(item);
			gold += (item.item().cost * item.quantity());
			self.model().money().gold(gold);
		};

		self.increaseQuantity = function(item) {
			var quantity = item.quantity();
			var gold = self.model().money().gold();
			quantity *= 1;
			gold *= 1;
			if (gold - item.item().cost < 0) {
				return;
			}
			quantity += 1;
			item.quantity(quantity);
			gold -= item.item().cost;
			self.model().money().gold(gold);
		};
		
		self.canIncrease = function(item) {
			var gold = self.model().money().gold();
			gold *= 1;
			gold -= item.item().cost;
			return gold >= 0;
		};
		
		self.decreaseQuantity = function(item) {
			var quantity = item.quantity();
			var startingQuantity = item.startingQuantity();
			quantity *= 1;
			startingQuantity *= 1;
			if (quantity <= startingQuantity) {
				return;
			}
			quantity -= 1;
			item.quantity(quantity);
			var gold = self.model().money().gold();
			gold *= 1;
			gold += item.item().cost;
			self.model().money().gold(gold);
		};
		
		self.canDecrease = function(item) {
			return item.quantity() > item.startingQuantity();
		};
		
		$.getJSON("/items/gear", function(data) {
			var mapped = $.map(data, function(item) {
				return new CharacterItem(item)
			});
			self.gear(mapped);
		});
		$.getJSON("/items/armour", function(data) {
			var mapped = $.map(data, function(item) {
				return new CharacterItem(item)
			});
			self.armour(mapped);
		});
		$.getJSON("/items/weapons", function(data) {
			var mapped = $.map(data, function(item) {
				return new CharacterItem(item)
			});
			self.weapons(mapped);
		});
		$.getJSON("/items/packs", function(data) {
			var mapped = $.map(data, function(item) {
				return new CharacterItem(item)
			});
			self.packs(mapped);
		});
	}

	EquipmentStep.prototype = Object.create(WizardStep.prototype);
	EquipmentStep.prototype.constructor = EquipmentStep;

	return EquipmentStep;
});
