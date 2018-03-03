package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.ConditionImmunity;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.Condition;

public abstract class ConditionImmunityTrait extends Trait<List<Condition>> {
	public ConditionImmunityTrait(final Condition... conditions) {
		super(ConditionImmunity, new ArrayList<>());
		getThing().addAll(asList(conditions));
	}
}
