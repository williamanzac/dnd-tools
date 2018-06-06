define([ 'knockout', 'text!../components/wizard.html', '../model/WizardModel', '../lib/I18n', 'knockout-amd-helpers' ], function(ko, html, WizardModel, I18n) {
	var EXIT_ON_CLOSE = 1;
	var EXIT_ON_FINISH = 2;

	ko.amdTemplateEngine.defaultPath = "../tmpl";

	function Wizard(params) {
		var self = this;

		self.nextAction = function() {
			self.model().activeStep().applyState();
			self.model().nextStep();
		};
		self.previousAction = function() {
			self.model().previousStep();
		};
		self.lastAction = function() {
			self.model().activeStep().applyState();
			self.model().lastStep();
		};
		self.finishAction = function() {
			var finishStep = self.model().activeStep();
			finishStep.applyState();
			var defaultCloseOperation = self.defaultExitMode;

			// todo (ap): should really consider making this more OO.
			if (defaultCloseOperation == EXIT_ON_FINISH) {
				self.closeAction();
			} else if (defaultCloseOperation == EXIT_ON_CLOSE) {
				self.showCloseButton();
			} else {
				throw new InvalidStateException("Invalid finish operaion: " + defaultCloseOperation);
			}
		};
		self.cancelAction = function() {
			self.cancel();
		};
		self.closeAction = function() {
			self.close();
		};
		self.helpAction = function() {
			var helpBroker = self.helpBroker();

			if (helpBroker != null) {
				helpBroker.activateHelp(self, self.model());
			}
		};

		self.helpBroker = ko.observable();

		self.activeStep = ko.observable();
		if (params === undefined || params.model === undefined) {
			self.model = ko.observable(new WizardModel());
		} else {
			self.model = ko.observable(ko.unwrap(params.model));
		}
		self.defaultExitMode = EXIT_ON_FINISH;
		
		self.i18n = ko.observable(new I18n(self.model));

		// private final JComponent titleComponent;
		// private final ButtonBar buttonBar;
		// private final JPanel viewPanel;
		// private final JPanel mainContainer;
		// private final JPanel overviewContainer;

		// private boolean overviewVisible = true;

		self.canceled = ko.observable(false);

		self.handleStepChange = function() {
			if (self.model().activeStep() === undefined) {
				return;
			}
			self.model().activeStep().prepare();

			self.activeStep(self.model().activeStep());
		};

		self.reset = function() {
			self.canceled(false);
			self.model().reset();
		};

		self.cancel = function() {
			var activeStep = self.model().activeStep();
			if (activeStep != null && activeStep.busy()) {
				if (!self.confirmAbort()) {
					return;
				}

				activeStep.abortBusy();
			}

			self.canceled(true);
		};

		self.confirmAbort = function() {
			// final int response = JOptionPane.showConfirmDialog(this, "Cancel the currently active task?", "Abort",
			// JOptionPane.YES_NO_CANCEL_OPTION);
			// return response == JOptionPane.YES_OPTION;
		};

		self.close = function() {
			// fireWizardClosed();
		};

		if (self.model !== undefined && self.model().activeStep !== undefined) {
			self.model().activeStep.subscribe(self.handleStepChange);
		}

		if (self.model !== undefined && self.model().stepIterator !== undefined && self.model().stepIterator() !== undefined) {
			self.model().stepIterator().forEach(function(step) {
				step.init(self.model());
			});
		}

		// if (model instanceof HelpBroker) {
		// setHelpBroker((HelpBroker) model);
		// }

		self.model().reset();
	}

	return {
	    viewModel : Wizard,
	    template : html
	};
});