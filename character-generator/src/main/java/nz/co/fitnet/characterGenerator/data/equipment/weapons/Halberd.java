package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Heavy;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Reach;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Halberd extends Weapon {
	public Halberd() {
		super(6, Martial, Melee, Slashing, "1d10", null, 20, Heavy, Reach, TwoHanded);
	}
}
