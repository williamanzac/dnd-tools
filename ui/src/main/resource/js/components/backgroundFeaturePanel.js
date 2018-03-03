define([ 'knockout', 'text!../components/backgroundFeaturePanel.html', '../lib/I18n' ], function(ko, html, I18n) {

	function BackgroundFeaturePanel(params) {
		var self = this;
		
		self.expanded = ko.observable(false);
		self.feature = ko.observable(ko.unwrap(params.feature));
		self.model = ko.observable(ko.unwrap(params.model));
		self.i18n = ko.observable(new I18n(self.model));
		
		self.languages = ko.observableArray();

		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};

		self.toggleLanguage = function(language) {
			if (self.languageKnown(language)) {
				return;
			}
			if (self.languageSelected(language)) {
				self.model().backgroundLanguages.remove(language);
			} else if (self.model().backgroundLanguages().length >= self.model().background().knownLanguages.additionalLanguages) {
				return;
			} else {
				self.model().backgroundLanguages.push(language);
			}
		};
		
		self.toggleSkill = function(skill) {
			if (self.skillKnown(skill)) {
				return;
			}
			if (self.skillSelected(skill)) {
				self.model().backgroundSkills.remove(skill.name);
			} else if (self.model().backgroundSkills().length >= self.model().background().skillProficiencies.numberSkillProficiencies) {
				return;
			} else {
				self.model().backgroundSkills.push(skill.name);
			}
		};
		
		self.languageKnown = function(language) {
			var race = self.model().race();
			return race.traits.filter(t => t.thing !== null && t.thing.languages !== undefined && t.thing.languages.indexOf(language) >= 0).length > 0 ||
				self.model().racialLanguages.indexOf(language) >= 0;
		};
		
		self.languageSelectable = function(language) {
			return !self.languageKnown(language) && 
				(self.languageSelected(language) ||
						self.model().backgroundLanguages().length < self.model().background().knownLanguages.additionalLanguages);
		};
		
		self.languageSelected = function(language) {
			return self.model().backgroundLanguages.indexOf(language) >= 0;
		};
		
		self.skillKnown = function(skill) {
			return self.model().race().traits.filter(t => t.thing !== null && t.thing.proficientSkills !== undefined && t.thing.proficientSkills.filter(s => s.name == skill.name).length > 0).length > 0 ||
				self.model().classSkills.indexOf(skill.name) >= 0;
		};
		
		self.skillSelectable = function(skill) {
			return !self.skillKnown(skill) && 
				(self.skillSelected(skill) ||
						self.model().backgroundSkills().length < self.model().background().skillProficiencies.numberSkillProficiencies);
		};
		
		self.skillSelected = function(skill) {
			return self.model().backgroundSkills.indexOf(skill.name) >= 0;
		};

		self.complete = ko.pureComputed(function() {
			if (self.feature().name === 'Proficiencies') {
				var skills = self.model().backgroundSkills().length === self.model().background().skillProficiencies.numberSkillProficiencies;
				var languages = self.model().backgroundLanguages().length === self.model().background().knownLanguages.additionalLanguages;
				return skills && languages;
			}
			return true;
		}, self);
		
		self.setPersonalityTrait = function(personalityTrait) {
			self.model().personalityTrait(personalityTrait);
		};
		
		self.setIdeal = function(ideal) {
			self.model().ideal(ideal);
		};
		
		self.setBond = function(bond) {
			self.model().bond(bond);
		};
		
		self.setFlaw = function(flaw) {
			self.model().flaw(flaw);
		};

		$.getJSON("/languages", function(data) {
			self.languages(data);
		});

		if (params.step !== undefined) {
			params.step.addFeaturePanel(self);
		}
	}

	return {
	    viewModel : BackgroundFeaturePanel,
	    template : html
	};
});