requirejs.config({
    baseUrl : '../../../js/lib',
    paths : {
        'jquery' : '//code.jquery.com/jquery-3.2.1.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min'
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../model/CharacterBuilderModel',
        '../model/RaceTraitsStep', 'domReady!' ], function($,
        bootstrap, ko, CharacterBuilderModel, RaceTraitsStep) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});
	ko.components.register('traitpanel', {
		require : '../components/traitPanel'
	});

	function Model() {
		var self = this;

		var step2 = new RaceTraitsStep();
		self.model = new CharacterBuilderModel();
		self.model.add(step2);

		$.getJSON("/races", function(races) {
			const result = races.filter(race => race.name == 'HalfElf');
			self.model.race(result[0]);
		});
	}
	ko.applyBindings(new Model());
});
