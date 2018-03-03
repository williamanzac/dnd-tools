package nz.co.fitnet.nameGenerator.data.names;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.data.names.definitions.ElfNames;

public class Elf extends NameDefinitionList {
	public Elf() {
		definitions.add(new ElfNames());
	}
}
