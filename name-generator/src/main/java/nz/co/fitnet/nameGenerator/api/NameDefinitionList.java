package nz.co.fitnet.nameGenerator.api;

import java.util.ArrayList;
import java.util.List;

public class NameDefinitionList {
	protected final List<NameDefinition> definitions = new ArrayList<>();

	public List<NameDefinition> getDefinitions() {
		return definitions;
	}

	public String getName() {
		return getClass().getSimpleName();
	}
}
