package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Thrown;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Handaxe extends Weapon {
	public Handaxe() {
		super(2, Simple, Slashing, "1d6", new WeaponRange(20, 60), 5, Light, Thrown);
	}
}
