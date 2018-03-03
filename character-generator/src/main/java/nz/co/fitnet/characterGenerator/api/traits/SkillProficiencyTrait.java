package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.SkillProficiency;

import nz.co.fitnet.characterGenerator.api.SkillProficiencies;
import nz.co.fitnet.characterGenerator.api.skills.Skill;

public abstract class SkillProficiencyTrait extends Trait<SkillProficiencies> {
	public SkillProficiencyTrait(final Skill... skills) {
		super(SkillProficiency, new SkillProficiencies(skills));
	}

	public SkillProficiencyTrait(final int numberSkillProficiencies) {
		super(SkillProficiency, new SkillProficiencies(numberSkillProficiencies));
	}
}
