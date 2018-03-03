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
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.MenacingTrait;

public class HalfOrc extends Race {
	public HalfOrc() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.STR, 2);
		abilityMods.put(Ability.CON, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(14, 75));
		// TODO alignment trait
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new HeightTrait(4 * 12 + 10, "2d10")); // 4'10"
		traits.add(new WeightTrait(140, "2d6")); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Orc));

		traits.add(new DarkvisionTrait());
		traits.add(new MenacingTrait());
		// TODO Relentless Endurance. When you are reduced to 0 hit points but not killed outright, you can drop to 1
		// hit point instead. You can’t use this feature again until you finish a long rest.
		// TODO Savage Attacks. When you score a critical hit with a melee weapon attack, you can roll one of the
		// weapon’s damage dice one additional time and add it to the extra damage of the critical hit.
	}
}
