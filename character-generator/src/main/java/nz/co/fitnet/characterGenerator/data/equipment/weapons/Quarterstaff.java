package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Versatile;

import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;

public class Quarterstaff extends Weapon {
	public Quarterstaff() {
		super(4, WeaponType.Simple, DamageType.Bludgeoning, "1d6", "1d8", null, 0.2, Versatile);
	}
}
