package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.KeenSensesTrait;

public abstract class Elf extends Race {
	public Elf() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.DEX, 2);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(100, 750));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Elvish));

		traits.add(new DarkvisionTrait());
		traits.add(new KeenSensesTrait());
		// TODO add advantage for charmed saving throws, cannot be put to sleep
		// TODO trance 4 hours
	}
}
