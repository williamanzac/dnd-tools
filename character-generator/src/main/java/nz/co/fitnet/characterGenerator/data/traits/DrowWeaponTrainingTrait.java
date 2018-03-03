package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.data.Weapons.HAND_CROSSBOW;
import static nz.co.fitnet.characterGenerator.data.Weapons.RAPIER;
import static nz.co.fitnet.characterGenerator.data.Weapons.SHORTSWORD;

import nz.co.fitnet.characterGenerator.api.traits.WeaponProficiencyTrait;

public class DrowWeaponTrainingTrait extends WeaponProficiencyTrait {
	public DrowWeaponTrainingTrait() {
		super(RAPIER, SHORTSWORD, HAND_CROSSBOW);
	}
}
