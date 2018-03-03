package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenToughnessTrait;

public class HillDwarf extends Dwarf {
	public HillDwarf() {
		traits.add(new HeightTrait(3 * 12 + 8, "2d4")); // 3'8"
		traits.add(new WeightTrait(115, "2d6")); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.WIS, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new DwarvenToughnessTrait());
	}
}
