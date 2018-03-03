package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.ExtraLanguageTrait;

public class HighElf extends Elf {
	public HighElf() {
		traits.add(new HeightTrait(4 * 12 + 6, "2d10")); // 4'6"
		traits.add(new WeightTrait(90, "1d4")); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.INT, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new ElfWeaponTrainingTrait());
		// TODO Cantrip. You know one cantrip of your choice from the wizard spell list. Intelligence is your
		// spellcasting ability for it.
		traits.add(new ExtraLanguageTrait());
	}
}
