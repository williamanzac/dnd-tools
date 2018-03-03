package nz.co.fitnet.ui.resource;

import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.WizardStep;

public class CharacterStepView<S extends WizardStep<CharacterBuilderModel>> extends StepView<S, CharacterBuilderModel> {
	public CharacterStepView(final S step, final CharacterBuilderModel model) {
		super("character", step, model);
	}
}
