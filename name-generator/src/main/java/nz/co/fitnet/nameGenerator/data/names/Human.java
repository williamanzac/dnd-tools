package nz.co.fitnet.nameGenerator.data.names;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.data.names.definitions.CalishiteNames;

public class Human extends NameDefinitionList {
	public Human() {
		definitions.add(new CalishiteNames());
	}
}
