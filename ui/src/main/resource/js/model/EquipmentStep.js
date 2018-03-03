define([ 'jquery', 'knockout', '../model/WizardStep', '../lib/I18n' ], function($, ko, WizardStep, I18n) {
	
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

		self.modes = ko.observableArray(["StartingEquipment", "Gold"]);
		self.currentMode = ko.observable();
		self.expanded = ko.observable(false);

		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};

		self.init = function(model) {
			self.model(ko.unwrap(model));
			self.i18n(new I18n(self.model));
			self.model().startingWealth.subscribe(self.updateComplete);

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
			if (this.numberOfChoices == 0 && this.items.length > 0) {
				this.items.forEach(function(item) {
					self.model().equipment.push(item);
				})
			}
			if (this.numberOfChoices > 0 && this.items.length > 0) {
				this.items.forEach(function(item) {
					if (self.selectedItems.indexOf(item.name) >= 0) {
						self.model().equipment.push(item);
					}
				});
			}
			if (this.numberOfChoices > 0 && this.options.length > 0) {
				this.options.forEach(function(item) {
					if (self.selectedOptions.indexOf(item.name) >= 0) {
						self.addOptionItems(item);
					}
				});
			}
		};

		self.updateComplete = function() {
			self.model().equipment([]);
			if (self.currentMode() == 'Gold') {
				self.complete(self.model().startingWealth() > 0);
			}
			if (self.currentMode() == 'StartingEquipment') {
				self.model().startingWealth(0);
				self.model().characterClass().startingEquipment.options.forEach(self.addOptionItems);
				self.model().background().startingEquipment.options.forEach(self.addOptionItems);
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
		
		self.modeSelected = function(mode) {
			return self.currentMode() === mode;
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
				self.model().startingWealth(money.gold);
			});
		};
	}

	EquipmentStep.prototype = Object.create(WizardStep.prototype);
	EquipmentStep.prototype.constructor = EquipmentStep;

	return EquipmentStep;
});
