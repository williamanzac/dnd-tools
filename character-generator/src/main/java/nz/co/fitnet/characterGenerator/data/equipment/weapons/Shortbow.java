package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Ranged;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Ammunition;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Shortbow extends Weapon {
	public Shortbow() {
		super(2, Simple, Ranged, Piercing, "1d6", new WeaponRange(80, 320), 25, Ammunition, TwoHanded);
	}
}
