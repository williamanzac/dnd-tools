package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Heavy;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Maul extends Weapon {
	public Maul() {
		super(10, Martial, Melee, Bludgeoning, "2d6", null, 10, Heavy, TwoHanded);
	}
}
