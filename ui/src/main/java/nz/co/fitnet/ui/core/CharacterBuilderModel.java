package nz.co.fitnet.ui.core;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.wizard.WizardStep;
import nz.co.fitnet.wizard.models.MultiPathModel;
import nz.co.fitnet.wizard.models.Path;

public class CharacterBuilderModel extends MultiPathModel<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> {

	private Race race;

	public CharacterBuilderModel(final Path<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> firstPath) {
		super(firstPath);
	}

	public Race getRace() {
		return race;
	}

	public void setRace(final Race race) {
		this.race = race;
	}
}
