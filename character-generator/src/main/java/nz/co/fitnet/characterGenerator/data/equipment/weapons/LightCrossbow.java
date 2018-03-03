package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Piercing;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Ammunition;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Loading;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.TwoHanded;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponRange;

public class LightCrossbow extends Weapon {
	public LightCrossbow() {
		super(5, Simple, Piercing, "1d8", new WeaponRange(80, 320), 25, Ammunition, Loading, TwoHanded);
	}
}
