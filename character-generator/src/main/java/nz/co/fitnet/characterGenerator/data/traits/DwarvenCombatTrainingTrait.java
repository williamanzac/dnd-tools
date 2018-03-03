package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.data.Weapons.BATTLEAXE;
import static nz.co.fitnet.characterGenerator.data.Weapons.HANDAXE;
import static nz.co.fitnet.characterGenerator.data.Weapons.LIGHT_HAMMER;
import static nz.co.fitnet.characterGenerator.data.Weapons.WARHAMMER;

import nz.co.fitnet.characterGenerator.api.traits.WeaponProficiencyTrait;

public class DwarvenCombatTrainingTrait extends WeaponProficiencyTrait {
	public DwarvenCombatTrainingTrait() {
		super(BATTLEAXE, HANDAXE, LIGHT_HAMMER, WARHAMMER);
	}
}
