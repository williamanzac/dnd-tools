package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiTrait extends Trait<List<Trait<?>>> {

	public MultiTrait(final TraitType type, final Trait<?>... traits) {
		super(type, new ArrayList<>());
		getThing().addAll(asList(traits));
	}
}
