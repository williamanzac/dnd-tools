package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class WarPick extends Weapon {
	public WarPick() {
		super(2, Martial, Melee, Piercing, "1d8", null, 5);
	}
}
