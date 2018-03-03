package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenArmorTrainingTrait;

public class MountainDwarf extends Dwarf {
	public MountainDwarf() {
		traits.add(new HeightTrait(4 * 12, "2d4")); // 4'
		traits.add(new WeightTrait(130, "2d6")); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.STR, 2);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new DwarvenArmorTrainingTrait());
	}
}
