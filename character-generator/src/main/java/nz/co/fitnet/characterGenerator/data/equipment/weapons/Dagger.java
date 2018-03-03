package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Finesse;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Thrown;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Dagger extends nz.co.fitnet.characterGenerator.api.equipment.Weapon {
	public Dagger() {
		super(1, Simple, Piercing, "1d4", new WeaponRange(20, 60), 2, Finesse, Light, Thrown);
	}
}
