package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.skills.Skill;

public class SkillProficiencies {
	private final List<Skill> proficientSkills = new ArrayList<>(); // options?
	private int numberSkillProficiencies;// options?

	public SkillProficiencies() {
	}

	public SkillProficiencies(final Skill... skills) {
		this(0, skills);
	}

	public SkillProficiencies(final int numberSkillProficiencies) {
		this(numberSkillProficiencies, (Skill[]) null);
	}

	public SkillProficiencies(final int numberSkillProficiencies, final Skill... skills) {
		if (skills != null) {
			proficientSkills.addAll(asList(skills));
		}
		this.numberSkillProficiencies = numberSkillProficiencies;
	}

	public List<Skill> getProficientSkills() {
		return proficientSkills;
	}

	public int getNumberSkillProficiencies() {
		return numberSkillProficiencies;
	}

	public void setNumberSkillProficiencies(final int numberSkillProficiencies) {
		this.numberSkillProficiencies = numberSkillProficiencies;
	}
}
