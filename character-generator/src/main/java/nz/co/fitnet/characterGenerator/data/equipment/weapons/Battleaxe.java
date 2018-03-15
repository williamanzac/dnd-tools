package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Slashing;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Versatile;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Battleaxe extends Weapon {
	public Battleaxe() {
		super(4, Martial, Melee, Slashing, "1d8", "1d10", null, 10, Versatile);
	}
}
