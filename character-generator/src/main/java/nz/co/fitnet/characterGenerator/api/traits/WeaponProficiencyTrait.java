package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.WeaponProficiency;

import nz.co.fitnet.characterGenerator.api.WeaponProficiencies;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;

public abstract class WeaponProficiencyTrait extends Trait<WeaponProficiencies> {

	public WeaponProficiencyTrait(final Weapon... weapons) {
		super(WeaponProficiency, new WeaponProficiencies(weapons));
	}

	public WeaponProficiencyTrait(final WeaponType... weaponTypes) {
		super(WeaponProficiency, new WeaponProficiencies(weaponTypes));
	}
}
