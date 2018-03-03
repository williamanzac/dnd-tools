package nz.co.fitnet.characterGenerator.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.co.fitnet.characterGenerator.api.equipment.StartingEquipment;
import nz.co.fitnet.characterGenerator.api.equipment.StartingWealth;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public abstract class CharacterClass {
	protected int hitDice;
	protected ArmourProficiencies armourProficiencies = new ArmourProficiencies();
	protected WeaponProficiencies weaponProficiencies = new WeaponProficiencies();
	protected ToolProficiencies toolProficiencies = new ToolProficiencies();
	protected final List<Ability> savingThrowProficiencies = new ArrayList<>();
	protected SkillProficiencies skillProficiencies = new SkillProficiencies();
	protected final List<Feature> features = new ArrayList<>();
	protected StartingEquipment startingEquipment;
	protected List<Archetype> archetypes = new ArrayList<>();
	protected StartingWealth startingWealth;
	protected Map<Ability, Integer> multiclassingPrerequisites = new HashMap<>();

	public String getName() {
		return getClass().getSimpleName();
	}

	public int getHitDice() {
		return hitDice;
	}

	public void setHitDice(final int hitDice) {
		this.hitDice = hitDice;
	}

	public ArmourProficiencies getArmourProficiencies() {
		return armourProficiencies;
	}

	public void setArmourProficiencies(final ArmourProficiencies armourProficiencies) {
		this.armourProficiencies = armourProficiencies;
	}

	public WeaponProficiencies getWeaponProficiencies() {
		return weaponProficiencies;
	}

	public void setWeaponProficiencies(final WeaponProficiencies weaponProficiencies) {
		this.weaponProficiencies = weaponProficiencies;
	}

	public ToolProficiencies getToolProficiencies() {
		return toolProficiencies;
	}

	public void setToolProficiencies(final ToolProficiencies toolProficiencies) {
		this.toolProficiencies = toolProficiencies;
	}

	public SkillProficiencies getSkillProficiencies() {
		return skillProficiencies;
	}

	public void setSkillProficiencies(final SkillProficiencies skillProficiencies) {
		this.skillProficiencies = skillProficiencies;
	}

	public List<Ability> getSavingThrowProficiencies() {
		return savingThrowProficiencies;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public StartingEquipment getStartingEquipment() {
		return startingEquipment;
	}

	public void setStartingEquipment(final StartingEquipment startingEquipment) {
		this.startingEquipment = startingEquipment;
	}

	public List<Archetype> getArchetypes() {
		return archetypes;
	}

	public void setArchetypes(final List<Archetype> archetypes) {
		this.archetypes = archetypes;
	}

	public StartingWealth getStartingWealth() {
		return startingWealth;
	}

	public void setStartingWealth(final StartingWealth startingWealth) {
		this.startingWealth = startingWealth;
	}

	public Map<Ability, Integer> getMulticlassingPrerequisites() {
		return multiclassingPrerequisites;
	}

	public void setMulticlassingPrerequisites(final Map<Ability, Integer> multiclassingPrerequisites) {
		this.multiclassingPrerequisites = multiclassingPrerequisites;
	}
}
