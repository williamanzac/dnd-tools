package nz.co.fitnet.nameGenerator.api;

import static java.util.Arrays.asList;
import static nz.co.fitnet.nameGenerator.api.Type.Any;

import java.util.ArrayList;
import java.util.List;

public class NamePartDefinition {
	private final Type generationType;
	private final String key;
	private final List<String> names = new ArrayList<>();

	public NamePartDefinition(final Type generationType, final String key, final String... names) {
		this.generationType = generationType;
		this.key = key;
		this.names.addAll(asList(names));
	}

	public NamePartDefinition(final String key, final String... names) {
		this(Any, key, names);
	}

	public Type getGenerationType() {
		return generationType;
	}

	public String getKey() {
		return key;
	}

	public List<String> getNames() {
		return names;
	}
}
