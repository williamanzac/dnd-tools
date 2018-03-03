package nz.co.fitnet.characterGenerator.data.features;

import static java.lang.Math.min;
import static nz.co.fitnet.characterGenerator.api.Ability.CON;
import static nz.co.fitnet.characterGenerator.api.Ability.DEX;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;

import nz.co.fitnet.characterGenerator.api.Character;
import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public class UnarmoredDefence extends Feature {
	private final int baseAC;

	public UnarmoredDefence() {
		super(1);
		baseAC = 10;
	}

	public int getBaseAC() {
		return baseAC;
	}

	public int getAC(final int dexMod, final int conMod) {
		return baseAC + dexMod + conMod;
	}

	public void applyTo(final Character character) {
		final Armour equippedArmour = character.getEquippedArmour();
		if (equippedArmour == null) {
			final int conMod = character.getAbilityScoreModifier(CON);
			final int dexMod = character.getAbilityScoreModifier(DEX);
			final int ac = getAC(dexMod, conMod);
			character.setAC(ac);
		} else {
			int ac = equippedArmour.getAC();
			final int dexMod = character.getAbilityScoreModifier(DEX);
			if (equippedArmour.isPlusDex()) {
				if (equippedArmour.getType() == Light) {
					ac += dexMod;
				}
				if (equippedArmour.getType() == Medium) {
					ac += min(dexMod, 2);
				}
			}
			character.setAC(ac);
		}
	}
}
