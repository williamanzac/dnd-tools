requirejs.config({
    baseUrl : '../../js/lib',
    paths : {
        'jquery' : '//code.jquery.com/jquery-3.2.1.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min'
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../model/CharacterBuilderModel', '../model/ChooseRaceStep',
        '../model/RaceTraitsStep', '../model/ChooseClassStep', '../model/ClassFeaturesStep',
        '../model/AbilityScoreStep', '../model/ChooseBackgroundStep', '../model/BackgroundFeaturesStep',
        '../model/CharacterDetailsStep','../model/EquipmentStep', '../lib/I18n', 'domReady!' ], function($, bootstrap, ko, CharacterBuilderModel,
        ChooseRaceStep, RaceTraitsStep, ChooseClassStep, ClassFeaturesStep, AbilityScoreStep, ChooseBackgroundStep,
        BackgroundFeaturesStep, CharacterDetailsStep, EquipmentStep, I18n) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.components.register('wizard', {
		require : '../components/wizard'
	});
	ko.components.register('traitpanel', {
		require : '../components/traitPanel'
	});
	ko.components.register('classfeaturepanel', {
		require : '../components/classFeaturePanel'
	});
	ko.components.register('backgroundfeaturepanel', {
		require : '../components/backgroundFeaturePanel'
	});
	ko.components.register('characterdetailpanel', {
		require : '../components/characterDetailPanel'
	});

	function Model() {
		var self = this;

		self.model = new CharacterBuilderModel();
		self.i18n = new I18n(self.model);

		var step1 = new ChooseRaceStep(self.i18n);
		//var step2 = new RaceTraitsStep(self.i18n);
		var step3 = new ChooseClassStep(self.i18n);
		//var step4 = new ClassFeaturesStep(self.i18n);
		var step5 = new AbilityScoreStep(self.i18n);
		var step6 = new ChooseBackgroundStep(self.i18n);
		//var step7 = new BackgroundFeaturesStep(self.i18n);
		var step8 = new CharacterDetailsStep(self.i18n);
		var step9 = new EquipmentStep(self.i18n);

		self.model.add(step1);
		//self.model.add(step2);
		self.model.add(step3);
		//self.model.add(step4);
		self.model.add(step5);
		self.model.add(step6);
		//self.model.add(step7);
		self.model.add(step8);
		self.model.add(step9);
		
	}
	ko.applyBindings(new Model());
});
