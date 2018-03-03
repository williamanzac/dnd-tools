package nz.co.fitnet.nameGenerator.data.names;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.data.names.definitions.DwarfNames;

public class Dwarf extends NameDefinitionList {
	public Dwarf() {
		definitions.add(new DwarfNames());
	}
}
