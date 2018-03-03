package nz.co.fitnet.ui.api;

import nz.co.fitnet.characterGenerator.data.races.Dwarf;

public class DwarfStep extends RaceStep<Dwarf> {
	public DwarfStep() {
		super();
	}

	@Override
	public boolean isComplete() {
		return true;
	}
}
