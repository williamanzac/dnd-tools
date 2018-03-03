requirejs.config({
    baseUrl : '../../../js/lib',
    paths : {
        'jquery' : '//code.jquery.com/jquery-3.2.1.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min'
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../model/CharacterBuilderModel', '../model/AbilityScoreStep', 'domReady!' ], function($,
        bootstrap, ko, CharacterBuilderModel, AbilityScoreStep) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});

	function Model() {
		var self = this;

		var step5 = new AbilityScoreStep();
		self.model = new CharacterBuilderModel();
		self.model.add(step5);

		$.getJSON("/classes", function(classes) {
			const result = classes.filter(c => c.name == 'Barbarian');
			self.model.characterClass(result[0]);
		});

		$.getJSON("/races", function(races) {
			const result = races.filter(race => race.name == 'HalfElf');
			self.model.race(result[0]);
		});
		
		self.model.racialModifiers(['STR', 'CON']);
	}
	ko.applyBindings(new Model());
});
