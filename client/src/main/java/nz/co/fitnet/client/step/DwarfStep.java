package nz.co.fitnet.client.step;

import nz.co.fitnet.characterGenerator.data.races.Dwarf;

public class DwarfStep extends RaceStep<Dwarf> {
	private static final long serialVersionUID = -2263851850583817827L;

	public DwarfStep() {
		super();
	}

	@Override
	public boolean isComplete() {
		return true;
	}
}
