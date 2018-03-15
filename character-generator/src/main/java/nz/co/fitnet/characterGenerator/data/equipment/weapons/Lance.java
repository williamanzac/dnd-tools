package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Reach;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Special;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Lance extends Weapon {
	public Lance() {
		super(6, Martial, Melee, Piercing, "1d12", null, 10, Reach, Special);
	}
}
