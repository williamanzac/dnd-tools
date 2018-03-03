package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Versatile;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Longsword extends Weapon {
	public Longsword() {
		super(3, Martial, Slashing, "1d8", "1d10", null, 15, Versatile);
	}
}
