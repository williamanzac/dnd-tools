package nz.co.fitnet.characterGenerator.data.classes;

import static java.util.Arrays.asList;
import static nz.co.fitnet.characterGenerator.api.Ability.CON;
import static nz.co.fitnet.characterGenerator.api.Ability.STR;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Shield;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.ANIMAL_HANDLING;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.ATHLETICS;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.INTIMIDATION;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.NATURE;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.PERCEPTION;
import static nz.co.fitnet.characterGenerator.api.skills.Skills.SURVIVAL;
import static nz.co.fitnet.characterGenerator.data.Archetypes.PATH_OF_THE_BERSERKER;

import nz.co.fitnet.characterGenerator.api.ArmourProficiencies;
import nz.co.fitnet.characterGenerator.api.CharacterClass;
import nz.co.fitnet.characterGenerator.api.SkillProficiencies;
import nz.co.fitnet.characterGenerator.api.WeaponProficiencies;
import nz.co.fitnet.characterGenerator.api.equipment.StartingWealth;
import nz.co.fitnet.characterGenerator.data.features.AbilityScoreImprovement;
import nz.co.fitnet.characterGenerator.data.features.DangerSense;
import nz.co.fitnet.characterGenerator.data.features.PrimalPath;
import nz.co.fitnet.characterGenerator.data.features.Rage;
import nz.co.fitnet.characterGenerator.data.features.RecklessAttack;
import nz.co.fitnet.characterGenerator.data.features.UnarmoredDefence;
import nz.co.fitnet.characterGenerator.data.startingequipment.BarbarianStartingEquipment;

public class Barbarian extends CharacterClass {

	public Barbarian() {
		hitDice = 12;
		armourProficiencies = new ArmourProficiencies(Light, Medium, Shield);
		weaponProficiencies = new WeaponProficiencies(Simple, Martial);
		// Tools: none
		savingThrowProficiencies.addAll(asList(STR, CON));
		skillProficiencies = new SkillProficiencies(2, ANIMAL_HANDLING, ATHLETICS, INTIMIDATION, NATURE, PERCEPTION,
				SURVIVAL);
		features.addAll(asList(new Rage(), new UnarmoredDefence(), new RecklessAttack(), new DangerSense(),
				new PrimalPath(), new AbilityScoreImprovement(4, 2), new AbilityScoreImprovement(8, 2),
				new AbilityScoreImprovement(12, 2), new AbilityScoreImprovement(16, 2),
				new AbilityScoreImprovement(19, 2)));
		startingEquipment = new BarbarianStartingEquipment();
		startingWealth = new StartingWealth(2, 4, 10);

		archetypes.add(PATH_OF_THE_BERSERKER);
		multiclassingPrerequisites.put(STR, 13);
		// TODO add multiclassing proficiencies
	}
}
