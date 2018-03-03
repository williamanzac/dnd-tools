package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Sense;

import java.util.HashMap;
import java.util.Map;

import nz.co.fitnet.characterGenerator.api.Sense;

public abstract class SenseTrait extends Trait<Map<Sense, Integer>> {
	public SenseTrait(final Sense sense, final int value) {
		super(Sense, new HashMap<>());
		getThing().put(sense, value);
	}
}
