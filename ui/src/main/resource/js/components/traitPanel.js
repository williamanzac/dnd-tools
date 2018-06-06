define([ 'knockout', 'text!../components/traitPanel.html', '../lib/I18n' ], function(ko, html, I18n) {

	function TraitPanel(params) {
		var self = this;
		
		self.expanded = ko.observable(false);
		self.trait = ko.observable(ko.unwrap(params.trait));
		self.model = ko.observable(ko.unwrap(params.model));
		self.i18n = ko.observable(ko.unwrap(params.i18n));
		
		self.toggleExpanded = function() {
			self.expanded(!self.expanded());
		};
		
		if (params.step !== undefined) {
			params.step.addTraitPanel(self);
		}
	}

	return {
	    viewModel : TraitPanel,
	    template : html
	};
});