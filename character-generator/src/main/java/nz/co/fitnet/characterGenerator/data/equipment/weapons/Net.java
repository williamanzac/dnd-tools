package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Ranged;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Special;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Thrown;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class Net extends Weapon {
	public Net() {
		super(3, Martial, Ranged, null, "", new WeaponRange(5, 15), 1, Special, Thrown);
	}
}
