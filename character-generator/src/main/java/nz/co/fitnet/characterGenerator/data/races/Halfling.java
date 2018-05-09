package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;

public abstract class Halfling extends Race {
	public Halfling() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.DEX, 2);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(20, 250));
		// TODO alignment trait
		traits.add(new SizeTrait(Size.Small));
		height = new Measurement(2 * 12 + 7, "2d4"); // 2'7"
		weight = new Measurement(35, "1"); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 25));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Halfling));

		// TODO Lucky. When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die and
		// must use the new roll.
		// TODO Brave. You have advantage on saving throws against being frightened.
		// TODO Halfling Nimbleness. You can move through the space of any creature that is of a size larger than yours.
	}
}
