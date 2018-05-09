package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenToughnessTrait;

public class HillDwarf extends Dwarf {
	public HillDwarf() {
		height = new Measurement(3 * 12 + 8, "2d4"); // 3'8"
		weight = new Measurement(115, "2d6"); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.WIS, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new DwarvenToughnessTrait());
	}
}
