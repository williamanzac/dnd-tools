package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Ranged;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Ammunition;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Sling extends Weapon {
	public Sling() {
		super(0, Simple, Ranged, Bludgeoning, "1d4", new WeaponRange(30, 120), 0.1, Ammunition);
	}
}
