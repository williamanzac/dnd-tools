package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.Condition.Charmed;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.FeyAncestry;
import static nz.co.fitnet.characterGenerator.data.Spells.SLEEP;

import nz.co.fitnet.characterGenerator.api.traits.ConditionAdvantageTrait;
import nz.co.fitnet.characterGenerator.api.traits.MultiTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpellImmunityTrait;

public class FeyAncestryTrait extends MultiTrait {

	public FeyAncestryTrait() {
		super(FeyAncestry, new ConditionAdvantageTrait(Charmed), new SpellImmunityTrait(SLEEP));
	}
}
