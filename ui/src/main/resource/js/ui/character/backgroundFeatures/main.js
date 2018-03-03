requirejs.config({
    baseUrl : '../../../js/lib',
    paths : {
        'jquery' : '//code.jquery.com/jquery-3.2.1.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min'
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../model/CharacterBuilderModel', '../model/BackgroundFeaturesStep', 'domReady!' ], function($,
        bootstrap, ko, CharacterBuilderModel, BackgroundFeaturesStep) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});
	ko.components.register('backgroundfeaturepanel', {
		require : '../components/backgroundFeaturePanel'
	});

	function Model() {
		var self = this;

		var step7 = new BackgroundFeaturesStep();
		self.model = new CharacterBuilderModel();
		self.model.add(step7);

		$.getJSON("/classes", function(classes) {
			const result = classes.filter(c => c.name == 'Barbarian');
			self.model.characterClass(result[0]);
		});

		$.getJSON("/races", function(races) {
			const result = races.filter(race => race.name == 'HalfElf');
			self.model.race(result[0]);
		});

		$.getJSON("/backgrounds", function(backgrounds) {
			const result = backgrounds.filter(background => background.name == 'Acolyte');
			self.model.background(result[0]);
		});
	}
	ko.applyBindings(new Model());
});
