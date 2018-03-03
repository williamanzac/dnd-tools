package nz.co.fitnet.characterGenerator.data.races;

import static nz.co.fitnet.characterGenerator.api.Alignment.CHAOTIC_EVIL;
import static nz.co.fitnet.characterGenerator.api.Alignment.CHAOTIC_GOOD;
import static nz.co.fitnet.characterGenerator.api.Alignment.CHAOTIC_NEUTRAL;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.FeyAncestryTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.SkillVersatilityTrait;

public class HalfElf extends Race {
	public HalfElf() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.CHA, 2);
		traits.add(new AbilityModifiersTrait(2, abilityMods));
		traits.add(new AgeTrait(20, 180));
		traits.add(new AlignmentTrait(CHAOTIC_GOOD, CHAOTIC_NEUTRAL, CHAOTIC_EVIL));
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new HeightTrait(4 * 12 + 9, "2d8")); // 4'9"
		traits.add(new WeightTrait(110, "2d4")); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new DarkvisionTrait());
		traits.add(new FeyAncestryTrait());
		traits.add(new SkillVersatilityTrait(2));
		traits.add(new KnownLanguagesTrait(1, Language.Common, Language.Elvish));
	}
}
