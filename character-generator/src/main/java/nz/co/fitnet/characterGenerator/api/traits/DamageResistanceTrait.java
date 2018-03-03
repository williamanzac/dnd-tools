package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.DamageResistance;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.DamageType;

public abstract class DamageResistanceTrait extends Trait<List<DamageType>> {
	public DamageResistanceTrait(final DamageType... damageTypes) {
		super(DamageResistance, new ArrayList<>());
		getThing().addAll(asList(damageTypes));
	}
}
