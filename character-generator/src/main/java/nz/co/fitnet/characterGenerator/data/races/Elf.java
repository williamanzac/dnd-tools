package nz.co.fitnet.characterGenerator.data.races;

import static nz.co.fitnet.characterGenerator.api.Ability.DEX;
import static nz.co.fitnet.characterGenerator.api.Language.Common;
import static nz.co.fitnet.characterGenerator.api.Language.Elvish;
import static nz.co.fitnet.characterGenerator.api.MovementType.walk;
import static nz.co.fitnet.characterGenerator.api.Size.Medium;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.FeyAncestryTrait;
import nz.co.fitnet.characterGenerator.data.traits.KeenSensesTrait;
import nz.co.fitnet.characterGenerator.data.traits.TranceTrait;

public abstract class Elf extends Race {
	public Elf() {
		mods.addModifier(DEX, 2);
		traits.add(new AgeTrait(100, 750));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Medium));
		traits.add(new SpeedTrait(walk, 30));
		traits.add(new DarkvisionTrait());
		traits.add(new KeenSensesTrait());
		traits.add(new FeyAncestryTrait());
		traits.add(new TranceTrait());
		traits.add(new KnownLanguagesTrait(Common, Elvish));

	}
}
