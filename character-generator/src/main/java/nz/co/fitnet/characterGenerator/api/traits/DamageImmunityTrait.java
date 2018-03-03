package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.DamageImmunity;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.DamageType;

public abstract class DamageImmunityTrait extends Trait<List<DamageType>> {
	public DamageImmunityTrait(final DamageType... damageTypes) {
		super(DamageImmunity, new ArrayList<>());
		getThing().addAll(asList(damageTypes));
	}
}
