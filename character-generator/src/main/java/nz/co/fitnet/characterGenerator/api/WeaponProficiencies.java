package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;

public class WeaponProficiencies {
	private final List<Weapon> proficientWeapons = new ArrayList<>(); // options?
	private final List<WeaponType> proficientWeaponTypes = new ArrayList<>();// options?

	public WeaponProficiencies() {
	}

	public WeaponProficiencies(final Weapon... weapons) {
		proficientWeapons.addAll(asList(weapons));
	}

	public WeaponProficiencies(final WeaponType... weaponTypes) {
		proficientWeaponTypes.addAll(asList(weaponTypes));
	}

	public List<Weapon> getProficientWeapons() {
		return proficientWeapons;
	}

	public List<WeaponType> getProficientWeaponTypes() {
		return proficientWeaponTypes;
	}
}
