package nz.co.fitnet.characterGenerator.data.features;

import java.util.Map;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.AbilityModifiers;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public class AbilityScoreImprovement extends Feature {
	private final AbilityModifiers abilityModifiers;

	public AbilityScoreImprovement(final int level, final Map<Ability, Integer> abilityModifiers) {
		super(level);
		this.abilityModifiers = new AbilityModifiers(abilityModifiers);
	}

	public AbilityScoreImprovement(final int level, final int additionalModifiers) {
		super(level);
		abilityModifiers = new AbilityModifiers(additionalModifiers);
	}

	public AbilityScoreImprovement(final int level, final int additionalModifiers,
			final Map<Ability, Integer> abilityModifiers) {
		super(level);
		this.abilityModifiers = new AbilityModifiers(additionalModifiers, abilityModifiers);
	}

	public AbilityModifiers getAbilityModifiers() {
		return abilityModifiers;
	}
}
