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
import nz.co.fitnet.characterGenerator.data.traits.MenacingTrait;

public class HalfOrc extends Race {
	public HalfOrc() {
		mods.addModifier(Ability.STR, 2);
		mods.addModifier(Ability.CON, 1);
		traits.add(new AgeTrait(14, 75));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		height = new Measurement(4 * 12 + 10, "2d10"); // 4'10"
		weight = new Measurement(140, "2d6"); // lbs
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
