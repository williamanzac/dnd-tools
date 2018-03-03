package nz.co.fitnet.characterGenerator.data.features;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.Ability.STR;
import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public class Rage extends Feature {

	private final List<Ability> savingThrowAdvantages = new ArrayList<>();
	private final List<DamageType> damageResistances = new ArrayList<>();
	private final int[] numberOfRages = { 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, -1 };
	private final int[] rageDamage = { 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4 };

	public Rage() {
		super(1);
		savingThrowAdvantages.add(STR);
		damageResistances.addAll(asList(Bludgeoning, Piercing, Slashing));
	}

	public int getNumberOfRages(final int level) {
		return numberOfRages[level - 1];
	}

	public int getRageDamage(final int level) {
		return rageDamage[level - 1];
	}

	public List<Ability> getSavingThrowAdvantages() {
		return savingThrowAdvantages;
	}

	public List<DamageType> getDamageResistances() {
		return damageResistances;
	}
}
