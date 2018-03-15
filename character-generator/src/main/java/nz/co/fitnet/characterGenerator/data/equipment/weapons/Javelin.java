package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Thrown;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Javelin extends Weapon {
	public Javelin() {
		super(2, Simple, Melee, Piercing, "1d6", new WeaponRange(30, 120), 0.5, Thrown);
	}
}
