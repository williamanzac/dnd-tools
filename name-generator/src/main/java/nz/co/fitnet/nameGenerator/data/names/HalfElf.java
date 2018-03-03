package nz.co.fitnet.nameGenerator.data.names;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.data.names.definitions.CalishiteNames;
import nz.co.fitnet.nameGenerator.data.names.definitions.ElfNames;

public class HalfElf extends NameDefinitionList {
	public HalfElf() {
		definitions.add(new ElfNames());
		definitions.add(new CalishiteNames());
	}
}
