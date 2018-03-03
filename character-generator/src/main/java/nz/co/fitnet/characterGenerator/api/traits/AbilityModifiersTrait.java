package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.AbilityScoreIncrease;

import java.util.Map;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.AbilityModifiers;

public class AbilityModifiersTrait extends Trait<AbilityModifiers> {
	public AbilityModifiersTrait(final Map<Ability, Integer> abilityModifiers) {
		this(0, abilityModifiers);
	}

	public AbilityModifiersTrait(final int additionalModifiers, final Map<Ability, Integer> abilityModifiers) {
		super(AbilityScoreIncrease, new AbilityModifiers(additionalModifiers, abilityModifiers));
	}
}
