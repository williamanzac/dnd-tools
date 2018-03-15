package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Ranged;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Ammunition;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Heavy;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Loading;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class HeavyCrossbow extends Weapon {
	public HeavyCrossbow() {
		super(18, Martial, Ranged, Piercing, "1d10", new WeaponRange(100, 400), 50, Ammunition, Heavy, Loading,
				TwoHanded);
	}
}
