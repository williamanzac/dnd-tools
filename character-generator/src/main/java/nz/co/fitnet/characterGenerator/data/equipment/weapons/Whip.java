package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Finesse;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Reach;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Whip extends Weapon {
	public Whip() {
		super(3, Martial, Melee, Slashing, "1d4", null, 2, Finesse, Reach);
	}
}
