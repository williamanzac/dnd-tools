package nz.co.fitnet.ui.core;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.wizard.Wizard;
import nz.co.fitnet.wizard.WizardStep;

@Service
public class CharacterBuilder extends Wizard<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> {
	public CharacterBuilder(final CharacterBuilderModel model) {
		super(model);
	}
}
