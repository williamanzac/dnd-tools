package nz.co.fitnet.characterGenerator.api.traits;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.traits.TraitType.SkillDisadvantage;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.skills.Skill;

public class SkillDisadvantageTrait extends Trait<List<Skill>> {
	public SkillDisadvantageTrait(final Skill... skills) {
		super(SkillDisadvantage, new ArrayList<>());
		getThing().addAll(asList(skills));
	}
}
