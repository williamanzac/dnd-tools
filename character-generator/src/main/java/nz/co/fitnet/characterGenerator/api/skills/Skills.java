package nz.co.fitnet.characterGenerator.api.skills;

import static java.util.Arrays.asList;

import java.util.List;

public class Skills {
	public static final Acrobatics ACROBATICS = new Acrobatics();
	public static final AnimalHandling ANIMAL_HANDLING = new AnimalHandling();
	public static final Arcana ARCANA = new Arcana();
	public static final Athletics ATHLETICS = new Athletics();
	public static final Deception DECEPTION = new Deception();
	public static final History HISTORY = new History();
	public static final Insight INSIGHT = new Insight();
	public static final Intimidation INTIMIDATION = new Intimidation();
	public static final Investigation INVESTIGATION = new Investigation();
	public static final Medicine MEDICINE = new Medicine();
	public static final Nature NATURE = new Nature();
	public static final Perception PERCEPTION = new Perception();
	public static final Performance PERFORMANCE = new Performance();
	public static final Persuasion PERSUASION = new Persuasion();
	public static final Religion RELIGION = new Religion();
	public static final SleightOfHand SLEIGHT_OF_HAND = new SleightOfHand();
	public static final Stealth STEALTH = new Stealth();
	public static final Survival SURVIVAL = new Survival();

	public static final List<Skill> skillList = asList(ACROBATICS, ANIMAL_HANDLING, ARCANA, ATHLETICS, DECEPTION,
			HISTORY, INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION,
			RELIGION, SLEIGHT_OF_HAND, STEALTH, SURVIVAL);
}
