package nz.co.fitnet.client;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.wizard.models.MultiPathModel;
import nz.co.fitnet.wizard.models.Path;

public class CharacterBuilderModel extends MultiPathModel {

	private Race race;

	public CharacterBuilderModel(final Path firstPath) {
		super(firstPath);
	}

	public Race getRace() {
		return race;
	}

	public void setRace(final Race race) {
		this.race = race;
	}
}
