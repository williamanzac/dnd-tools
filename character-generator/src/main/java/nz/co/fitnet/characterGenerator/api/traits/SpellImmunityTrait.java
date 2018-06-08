package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.SpellImmunity;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.spells.Spell;

public class SpellImmunityTrait extends Trait<List<Spell>> {
	public SpellImmunityTrait(final Spell... spells) {
		super(SpellImmunity, new ArrayList<>());
		getThing().addAll(asList(spells));
	}
}
