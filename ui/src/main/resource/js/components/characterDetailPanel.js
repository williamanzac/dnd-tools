define([ 'knockout', 'text!../components/characterDetailPanel.html', '../lib/I18n' ], function(ko, html, I18n) {

	function CharacterDetailPanel(params) {
		var self = this;
		
		self.expanded = ko.observable(false);
		self.name = ko.observable(ko.unwrap(params.name));
		self.model = ko.observable(ko.unwrap(params.model));
		self.i18n = ko.observable(new I18n(self.model));
		
		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};

		self.complete = ko.pureComputed(function() {
			if (self.name() === 'CharacterDetail') {
				return self.model() !== undefined && self.model().alignment() !== undefined && self.model().name() !== undefined;
			}
			return true;
		}, self);
		
		self.setAlignment = function(alignment) {
			self.model().alignment(alignment);
		};
		
		self.alignmentSelected = function(alignment) {
			return self.model().alignment() !== undefined && alignment === self.model().alignment();
		};
		
		self.setLifestyle = function(lifestyle) {
			self.model().lifestyle(lifestyle);
		};
		
		self.lifestyleSelected = function(lifestyle) {
			return self.model().lifestyle() !== undefined && lifestyle.name === self.model().lifestyle().name;
		};
		
		self.setGender = function(gender) {
			self.model().gender(gender);
		};
		
		self.genderSelected = function(gender) {
			return self.model().gender() !== undefined && gender === self.model().gender();
		};
		
		self.generateName = function() {
			$.ajax({
				method : "POST",
				url : "/builder/name/" + self.model().race().name + (self.model().gender() !== undefined ? '/' + self.model().gender() : ''),
				contentType : "application/json",
				dataType : "text"
			}).done(function(name) {
				self.model().name(name);
			});
		};

		self.lifestyles = ko.observableArray([]);
		$.getJSON("/lifestyles", function(data) {
			self.lifestyles(data);
		});

		self.alignments = ko.observableArray([]);
		$.getJSON("/alignments", function(data) {
			self.alignments(data);
		});

		self.genders = ko.observableArray([]);
		$.getJSON("/genders", function(data) {
			self.genders(data);
		});

		if (params.step !== undefined) {
			params.step.addDetailPanel(self);
		}
	}

	return {
	    viewModel : CharacterDetailPanel,
	    template : html
	};
});