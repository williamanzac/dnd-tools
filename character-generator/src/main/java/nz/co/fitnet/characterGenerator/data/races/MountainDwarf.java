package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenArmorTrainingTrait;

public class MountainDwarf extends Dwarf {
	public MountainDwarf() {
		height = new Measurement(4 * 12, "2d4"); // 4'
		weight = new Measurement(130, "2d6"); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.STR, 2);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new DwarvenArmorTrainingTrait());
	}
}
