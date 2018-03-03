requirejs.config({
    baseUrl : '../../../js/lib',
    paths : {
        'jquery' : '//code.jquery.com/jquery-3.2.1.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min'
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../model/CharacterBuilderModel', '../model/ClassFeaturesStep', 'domReady!' ], function($,
        bootstrap, ko, CharacterBuilderModel, ClassFeaturesStep) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});
	ko.components.register('classfeaturepanel', {
		require : '../components/classFeaturePanel'
	});

	function Model() {
		var self = this;

		var step4 = new ClassFeaturesStep();
		self.model = new CharacterBuilderModel();
		self.model.add(step4);

		$.getJSON("/classes", function(classes) {
			const result = classes.filter(c => c.name == 'Barbarian');
			self.model.characterClass(result[0]);
		});
	}
	ko.applyBindings(new Model());
});
