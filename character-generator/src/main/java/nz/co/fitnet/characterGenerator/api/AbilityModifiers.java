package nz.co.fitnet.characterGenerator.api;

import java.util.HashMap;
import java.util.Map;

public class AbilityModifiers {
	private final Map<Ability, Integer> abilityModifiers = new HashMap<>();
	private int additionalModifiers;

	public AbilityModifiers(final Map<Ability, Integer> abilityModifiers) {
		this(0, abilityModifiers);
	}

	public AbilityModifiers(final int additionalModifiers, final Map<Ability, Integer> abilityModifiers) {
		this.abilityModifiers.putAll(abilityModifiers);
		this.additionalModifiers = additionalModifiers;
	}

	public AbilityModifiers(final int additionalModifiers) {
		this.additionalModifiers = additionalModifiers;
	}

	public int getAdditionalModifiers() {
		return additionalModifiers;
	}

	public void setAdditionalModifiers(final int additionalModifiers) {
		this.additionalModifiers = additionalModifiers;
	}

	public Map<Ability, Integer> getAbilityModifiers() {
		return abilityModifiers;
	}

	public void addModifier(final Ability ability, final int value) {
		abilityModifiers.put(ability, value);
	}
}
