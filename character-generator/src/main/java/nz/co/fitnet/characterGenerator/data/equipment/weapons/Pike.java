package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Heavy;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Reach;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Pike extends Weapon {
	public Pike() {
		super(18, Martial, Melee, Piercing, "1d10", null, 5, Heavy, Reach, TwoHanded);
	}
}
