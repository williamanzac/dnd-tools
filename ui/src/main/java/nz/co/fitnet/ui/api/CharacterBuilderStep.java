package nz.co.fitnet.ui.api;

import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.AbstractWizardStep;

public abstract class CharacterBuilderStep extends AbstractWizardStep<CharacterBuilderModel> {

	public CharacterBuilderStep() {
		super();
	}

	@Override
	public String getView() {
		return getClass().getSimpleName().toLowerCase();
	}
}
