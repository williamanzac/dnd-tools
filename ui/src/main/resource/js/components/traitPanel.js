define([ 'knockout', 'text!../components/traitPanel.html', '../lib/I18n' ], function(ko, html, I18n) {

	function TraitPanel(params) {
		var self = this;
		
		self.expanded = ko.observable(false);
		self.trait = ko.observable(ko.unwrap(params.trait));
		self.model = ko.observable(ko.unwrap(params.model));
		self.i18n = ko.observable(new I18n(self.model));
		
		self.abilities = ko.observableArray();
		self.languages = ko.observableArray();
		self.skills = ko.observableArray();
		
		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};
		
		self.templateName = function() {
			return self.trait().name + 'Trait';
		};

		self.toggleAbility = function(ability) {
			if (self.abilityKnown(ability)) {
				return;
			}
			if (self.abilitySelected(ability)) {
				self.model().racialModifiers.remove(ability);
			} else if (self.model().racialModifiers().length >= self.trait().thing.racialModifiers) {
				return;
			} else {
				self.model().racialModifiers.push(ability);
			}
		};
		
		self.toggleLanguage = function(language) {
			if (self.languageKnown(language)) {
				return;
			}
			if (self.languageSelected(language)) {
				self.model().racialLanguages.remove(language);
			} else if (self.model().racialLanguages().length >= self.trait().thing.additionalLanguages) {
				return;
			} else {
				self.model().racialLanguages.push(language);
			}
		};
		
		self.toggleSkill = function(skill) {
			if (self.skillKnown(skill)) {
				return;
			}
			if (self.skillSelected(skill)) {
				self.model().racialSkills.remove(skill.name);
			} else if (self.model().racialSkills().length >= self.trait().thing.numberSkillProficiencies) {
				return;
			} else {
				self.model().racialSkills.push(skill.name);
			}
		};
		
		self.generateAge = function() {
			var data = ko.toJS(self.trait().thing);
			$.ajax({
				method : "POST",
				url : "/builder/age",
				contentType : "application/json",
				dataType : "json",
				data: JSON.stringify(data)
			}).done(function(age) {
				self.model().age(age);
			});
		};
		
		self.generateHeight = function() {
			var data = ko.toJS(self.trait().thing);
			$.ajax({
				method : "POST",
				url : "/builder/height",
				contentType : "application/json",
				dataType : "json",
				data: JSON.stringify(data)
			}).done(function(height) {
				self.model().height(height);
			});
		};
		
		self.generateWeight = function() {
			var data = ko.toJS(self.trait().thing);
			$.ajax({
				method : "POST",
				url : "/builder/weight",
				contentType : "application/json",
				dataType : "json",
				data: JSON.stringify(data)
			}).done(function(weight) {
				self.model().weight(weight);
			});
		};
		
		self.abilityKnown = function(ability) {
			return self.trait().thing.abilityModifiers[ability] !== undefined;
		};
		
		self.abilitySelectable = function(ability) {
			return !self.abilityKnown(ability) &&
				(self.abilitySelected(ability) ||
						self.model().racialModifiers().length < self.trait().thing.additionalModifiers);
		};
		
		self.abilitySelected = function(ability) {
			return self.model().racialModifiers.indexOf(ability) >= 0;
		};
		
		self.languageKnown = function(language) {
			return self.trait().thing.languages.indexOf(language) >= 0 ||
				(self.model().background() !== undefined && self.model().background().knownLanguages.languages.indexOf(language) >= 0) ||
				self.model().backgroundLanguages.indexOf(language) >= 0;
		};
		
		self.languageSelectable = function(language) {
			return !self.languageKnown(language) && 
				(self.languageSelected(language) ||
						self.model().racialLanguages().length < self.trait().thing.additionalLanguages);
		};
		
		self.languageSelected = function(language) {
			return self.model().racialLanguages.indexOf(language) >= 0;
		};
		
		self.skillKnown = function(skill) {
			return self.trait().thing.proficientSkills.indexOf(skill.name) >= 0 ||
				(self.model().background() !== undefined && self.model().background().skillProficiencies.proficientSkills.filter(s => s.name == skill.name).length > 0) ||
				self.model().backgroundSkills.indexOf(skill.name) >= 0 ||
				self.model().classSkills.indexOf(skill.name) >= 0;
		};
		
		self.skillSelectable = function(skill) {
			return !self.skillKnown(skill) && 
				(self.skillSelected(skill) ||
						self.model().racialSkills().length < self.trait().thing.numberSkillProficiencies);
		};
		
		self.skillSelected = function(skill) {
			return self.model().racialSkills.indexOf(skill.name) >= 0;
		};
		
		self.complete = ko.pureComputed(function() {
			if (self.trait().type === 'AbilityScoreIncrease') {
				return self.model().racialModifiers().length === self.trait().thing.additionalModifiers;
			} else if (self.trait().type === 'Languages') {
				return self.model().racialLanguages().length === self.trait().thing.additionalLanguages;
			} else if (self.trait().type === 'SkillProficiency') {
				return self.model().racialSkills().length === self.trait().thing.numberSkillProficiencies;
			} else if (self.trait().type === 'Age') {
				return self.model().age() !== undefined;
			} else if (self.trait().type === 'Height') {
				return self.model().height() !== undefined;
			} else if (self.trait().type === 'Weight') {
				return self.model().weight() !== undefined;
			}
			return true;
		}, self);

		$.getJSON("/abilities", function(data) {
			self.abilities(data);
		});

		$.getJSON("/languages", function(data) {
			self.languages(data);
		});

		$.getJSON("/skills", function(data) {
			self.skills(data);
		});
		
		if (params.step !== undefined) {
			params.step.addTraitPanel(self);
		}
		
		if (self.trait().type === 'AbilityScoreIncrease') {
			html = 'AbilityScoreIncrease';
		};
	}

	return {
	    viewModel : TraitPanel,
	    template : html
	};
});