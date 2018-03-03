package nz.co.fitnet.characterGenerator.api;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.StartingEquipment;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public class Background {
	protected final SkillProficiencies skillProficiencies = new SkillProficiencies();
	protected final ToolProficiencies toolProficiencies = new ToolProficiencies();
	protected final KnownLanguages knownLanguages = new KnownLanguages();
	protected final StartingEquipment startingEquipment = new StartingEquipment();
	protected final List<String> personalityTraits = new ArrayList<>();
	protected final List<String> ideals = new ArrayList<>();
	protected final List<String> bonds = new ArrayList<>();
	protected final List<String> flaws = new ArrayList<>();
	protected final List<Feature> features = new ArrayList<>();
	protected final Money money = new Money();

	public String getName() {
		return getClass().getSimpleName();
	}

	public SkillProficiencies getSkillProficiencies() {
		return skillProficiencies;
	}

	public ToolProficiencies getToolProficiencies() {
		return toolProficiencies;
	}

	public KnownLanguages getKnownLanguages() {
		return knownLanguages;
	}

	public StartingEquipment getStartingEquipment() {
		return startingEquipment;
	}

	public List<String> getPersonalityTraits() {
		return personalityTraits;
	}

	public List<String> getIdeals() {
		return ideals;
	}

	public List<String> getBonds() {
		return bonds;
	}

	public List<String> getFlaws() {
		return flaws;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public Money getMoney() {
		return money;
	}
}
