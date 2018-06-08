define([ 'jquery', 'knockout' ], function($, ko,
        AbilityScoreAdjustment, Language) {
	var baseurl = "/i18n";

	function I18n(model) {
		self = this;
		self.model = ko.observable(ko.unwrap(model));
		self.map = ko.observableArray([]);
		
		self.getKeys = function() {
			return Object.keys(self.map());
		};
		
		self.get = function(key) {
			//console.log(key);
			var value = self.map() !== undefined ? self.map()[key.toLowerCase()] : '';
			//console.log(value);
			if (value === undefined || value === null) {
				value = "!" + key + "!";
			}
			return value;
		};

		self.getForBackground = function(key) {
			if (self.model().background() !== undefined) {
				var tempKey = self.model().background().name + '.' + key;
				var value = self.get(tempKey);
				if (value !== undefined && value !== null && !value.startsWith("!")) {
					return value;
				}
			}
			return self.get(key);
		};

		self.getForClass = function(key) {
			if (self.model().characterClass() !== undefined) {
				var tempKey = self.model().characterClass().name + '.' + key;
				var value = self.get(tempKey);
				if (value !== undefined && value !== null && !value.startsWith("!")) {
					return value;
				}
			}
			return self.get(key);
		};

		self.getForRace = function(key) {
			if (self.model().race() !== undefined) {
				var tempKey = self.model().race().name + '.' + key;
				var value = self.get(tempKey);
				if (value !== undefined && value !== null && !value.startsWith("!")) {
					return value;
				}
				
				tempKey = self.model().race().parentName + '.' + key;
				value = self.get(tempKey);
				if (value !== undefined && value !== null && !value.startsWith("!")) {
					return value;
				}
			}
			return self.get(key);
		};
		
		self.getFormatted = function(key) {
			var formatted = self.get(key);
			if (formatted === undefined) {
				return null;
			}
			var args = Array.prototype.slice.call(arguments, 1);
			return formatted.replace(/{(\d+)}/g, function(match, number) {
				return typeof args[number] != 'undefined' ? args[number] : match;
			});
		};
		
		self.getFormattedBackground = function(key) {
			if (self.model().background() !== undefined) {
				var tempKey = self.model().background().name + '.' + key;
				var value = self.getFormatted(tempKey);
				if (value !== undefined && value !== null) {
					return value;
				}
			}
			return self.getFormatted(key);
		};
		
		self.getFormattedClass = function(key) {
			if (self.model().characterClass() !== undefined) {
				var tempKey = self.model().characterClass().name + '.' + key;
				var value = self.getFormatted(tempKey);
				if (value !== undefined && value !== null) {
					return value;
				}
			}
			return self.getFormatted(key);
		};
		
		self.getFormattedRace = function(key) {
			if (self.model().race() !== undefined) {
				var tempKey = self.model().race().name + '.' + key;
				var value = self.getFormatted(tempKey);
				if (value !== undefined && value !== null) {
					return value;
				}

				tempKey = self.model().race().name + '.' + key;
				value = self.getFormatted(tempKey);
				if (value !== undefined && value !== null) {
					return value;
				}
			}
			return self.getFormatted(key);
		};
		
		$.getJSON(baseurl, function(data) {
			self.map(data);
		});
	}
	
	return I18n;
});