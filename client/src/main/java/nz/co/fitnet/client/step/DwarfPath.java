package nz.co.fitnet.client.step;

import nz.co.fitnet.characterGenerator.data.races.Dwarf;

public class DwarfPath extends RacePath<Dwarf> {
	public DwarfPath() {
		super(new DwarfStep());
	}
}
