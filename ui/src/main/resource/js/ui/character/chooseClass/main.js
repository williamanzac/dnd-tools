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
        '../model/ChooseClassStep', 'domReady!' ], function($,
        bootstrap, ko, CharacterBuilderModel, ChooseClassStep) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});

	function Model() {
		var self = this;

		var step3 = new ChooseClassStep();
		self.model = new CharacterBuilderModel();
		self.model.add(step3);
	}
	ko.applyBindings(new Model());
});
