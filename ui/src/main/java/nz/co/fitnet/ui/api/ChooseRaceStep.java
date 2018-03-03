package nz.co.fitnet.ui.api;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.Races;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.InvalidStateException;

public class ChooseRaceStep extends CharacterBuilderStep {
	private final List<Race> races = new ArrayList<>();
	private CharacterBuilderModel model;

	public ChooseRaceStep() {
		super();
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public void prepare() {
	}

	@Override
	public void applyState() throws InvalidStateException {
	}

	@Override
	public void init(final CharacterBuilderModel model) {
		this.model = model;
		races.addAll(Races.raceList);
	}

	public void setRace(final Race race) {
		model.setRace(race);
	}

	@Override
	public boolean isComplete() {
		return model.getRace() != null;
	}
}
