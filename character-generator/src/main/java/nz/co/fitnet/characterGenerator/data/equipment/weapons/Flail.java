package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Flail extends Weapon {
	public Flail() {
		super(2, Martial, Melee, Bludgeoning, "1d8", null, 10);
	}
}
