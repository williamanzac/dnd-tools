package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.ArmourProficiency;

import nz.co.fitnet.characterGenerator.api.ArmourProficiencies;
import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.equipment.ArmourType;

public abstract class ArmourProficiencyTrait extends Trait<ArmourProficiencies> {

	public ArmourProficiencyTrait(final Armour... armours) {
		super(ArmourProficiency, new ArmourProficiencies(armours));
	}

	public ArmourProficiencyTrait(final ArmourType... armourTypes) {
		super(ArmourProficiency, new ArmourProficiencies(armourTypes));
	}
}
