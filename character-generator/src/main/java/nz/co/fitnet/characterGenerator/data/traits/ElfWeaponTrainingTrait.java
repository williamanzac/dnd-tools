package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.data.Weapons.LONGBOW;
import static nz.co.fitnet.characterGenerator.data.Weapons.LONGSWORD;
import static nz.co.fitnet.characterGenerator.data.Weapons.SHORTBOW;
import static nz.co.fitnet.characterGenerator.data.Weapons.SHORTSWORD;

import nz.co.fitnet.characterGenerator.api.traits.WeaponProficiencyTrait;

public class ElfWeaponTrainingTrait extends WeaponProficiencyTrait {
	public ElfWeaponTrainingTrait() {
		super(LONGSWORD, SHORTSWORD, SHORTBOW, LONGBOW);
	}
}
