package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Thrown;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Versatile;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Trident extends Weapon {
	public Trident() {
		super(4, Martial, Piercing, "1d6", "1d8", new WeaponRange(20, 60), 5, Thrown, Versatile);
	}
}
