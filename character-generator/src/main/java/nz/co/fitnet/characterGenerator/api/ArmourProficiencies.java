package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.equipment.ArmourType;

public class ArmourProficiencies {
	private final List<Armour> proficientArmours = new ArrayList<>(); // options?
	private final List<ArmourType> proficientArmourTypes = new ArrayList<>();// options?

	public ArmourProficiencies() {
	}

	public ArmourProficiencies(final Armour... armours) {
		proficientArmours.addAll(asList(armours));
	}

	public ArmourProficiencies(final ArmourType... armourTypes) {
		proficientArmourTypes.addAll(asList(armourTypes));
	}

	public List<Armour> getProficientArmours() {
		return proficientArmours;
	}

	public List<ArmourType> getProficientArmourTypes() {
		return proficientArmourTypes;
	}
}
