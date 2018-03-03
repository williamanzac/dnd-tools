package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;

public class Human extends Race {
	public Human() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		for (final Ability ability : Ability.values()) {
			abilityMods.put(ability, 1);
		}
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(18, 100));
		// TODO alignment trait
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new HeightTrait(4 * 12 + 8, "2d10")); // 4'8"
		traits.add(new WeightTrait(110, "2d4"));// lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(1, Language.Common));
	}
}
