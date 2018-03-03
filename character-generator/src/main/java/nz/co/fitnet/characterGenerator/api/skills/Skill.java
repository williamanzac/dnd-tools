package nz.co.fitnet.characterGenerator.api.skills;

import nz.co.fitnet.characterGenerator.api.Ability;

public abstract class Skill {
	private final Ability ability;

	public Skill(final Ability ability) {
		this.ability = ability;
	}

	public String getName() {
		return getClass().getSimpleName();
	}

	public Ability getAbility() {
		return ability;
	}
}
