package nz.co.fitnet.nameGenerator.api;

import java.util.ArrayList;
import java.util.List;

public class NameDefinition {
	protected String format;
	protected final List<NamePartDefinition> nameParts = new ArrayList<>();

	public String getFormat() {
		return format;
	}

	public List<NamePartDefinition> getNameParts() {
		return nameParts;
	}

	public NamePartDefinition getPart(final String key) {
		final NamePartDefinition part = nameParts.stream().filter(p -> key.equals(p.getKey())).findFirst().orElse(null);
		return part;
	}

	public String getName() {
		return getClass().getSimpleName();
	}
}
