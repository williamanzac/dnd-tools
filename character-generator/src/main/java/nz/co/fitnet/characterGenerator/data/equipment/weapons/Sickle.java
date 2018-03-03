package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Sickle extends Weapon {
	public Sickle() {
		super(2, Simple, Slashing, "1d4", null, 1, Light);
	}
}
