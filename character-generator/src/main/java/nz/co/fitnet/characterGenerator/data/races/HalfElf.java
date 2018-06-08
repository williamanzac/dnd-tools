package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.FeyAncestryTrait;
import nz.co.fitnet.characterGenerator.data.traits.SkillVersatilityTrait;

public class HalfElf extends Race {
	public HalfElf() {
		mods.addModifier(Ability.CHA, 2);
		mods.setAdditionalModifiers(2);
		traits.add(new AgeTrait(20, 180));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		height = new Measurement(4 * 12 + 9, "2d8"); // 4'9"
		weight = new Measurement(110, "2d4"); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new DarkvisionTrait());
		traits.add(new FeyAncestryTrait());
		traits.add(new SkillVersatilityTrait(2));
		traits.add(new KnownLanguagesTrait(1, Language.Common, Language.Elvish));
	}
}
