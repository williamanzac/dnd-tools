define([ 'knockout', 'text!../components/classFeaturePanel.html', '../lib/I18n' ], function(ko, html, I18n) {

	function ClassFeaturePanel(params) {
		var self = this;
		
		self.expanded = ko.observable(false);
		self.feature = ko.observable(ko.unwrap(params.feature));
		self.model = ko.observable(ko.unwrap(params.model));
		self.i18n = ko.observable(ko.unwrap(params.i18n));
		
		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};

		self.toggleSkill = function(skill) {
			if (self.skillSelected(skill)) {
				self.model().classSkills.remove(skill.name);
			} else if (self.model().classSkills().length >= self.model().characterClass().skillProficiencies.numberSkillProficiencies) {
				return;
			} else {
				self.model().classSkills.push(skill.name);
			}
		};
		
		self.skillKnown = function(skill) {
			return (self.model().background() !== undefined && self.model().background().skillProficiencies.proficientSkills.filter(s => s.name == skill.name).length > 0) ||
				self.model().backgroundSkills.indexOf(skill.name) >= 0 ||
				self.model().race().traits.filter(t => t.thing !== null && t.thing.proficientSkills !== undefined && t.thing.proficientSkills.filter(s => s.name == skill.name).length > 0).length > 0 || 
				self.model().racialSkills.indexOf(skill.name) >= 0;
		};
		
		self.skillSelectable = function(skill) {
			return !self.skillKnown(skill) && 
				(self.skillSelected(skill) ||
						self.model().classSkills().length < self.model().characterClass().skillProficiencies.numberSkillProficiencies);
		};
		
		self.skillSelected = function(skill) {
			return self.model().classSkills.indexOf(skill.name) >= 0;
		};

		self.complete = ko.pureComputed(function() {
			if (self.feature().name === 'Proficiencies') {
				return self.model().classSkills().length === self.model().characterClass().skillProficiencies.numberSkillProficiencies;
			}
			return true;
		}, self);

		if (params.step !== undefined) {
			params.step.addFeaturePanel(self);
		}
	}

	return {
	    viewModel : ClassFeaturePanel,
	    template : html
	};
});