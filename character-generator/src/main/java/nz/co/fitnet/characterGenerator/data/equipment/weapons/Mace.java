package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Mace extends Weapon {
	public Mace() {
		super(4, Simple, DamageType.Bludgeoning, "1d6", null, 5);
	}
}
