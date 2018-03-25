package nz.co.fitnet.characterGenerator.core.builders;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Background;
import nz.co.fitnet.characterGenerator.api.Character;
import nz.co.fitnet.characterGenerator.api.CharacterClass;
import nz.co.fitnet.characterGenerator.api.Gender;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.equipment.CharacterItem;
import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.characterGenerator.data.Backgrounds;
import nz.co.fitnet.numberGenerator.api.NumberService;

@Service
public class CharacterBuilder {

	private final RandomComparator<Gender> genderComparator;
	private final RandomComparator<Background> backgroundComparator;

	public static class CharacterBuilderException extends Exception {
		private static final long serialVersionUID = -1174219164699864073L;

		public CharacterBuilderException(final String message) {
			super(message);
		}
	}

	private final HeightAndWeightBuilder heightAndWeightBuilder;
	private final AgeBuilder ageBuilder;
	private final LanguageBuilder languageBuilder;
	private final AbilitiesBuilder abilitiesBuilder;
	private final ProficiencyBuilder proficiencyBuilder;
	private final StartingEquipmentBuilder startingEquipmentBuilder;
	private final BackgroundBuilder backgroundBuilder;
	private final StartingWealthBuilder startingWealthBuilder;

	private Race race;
	private final Map<Ability, Integer> abilityScores = new HashMap<>();
	private final Map<Ability, Integer> abilityMods = new HashMap<>();
	private final List<Language> languages = new ArrayList<>();
	private final Map<CharacterClass, Integer> classLevels = new LinkedHashMap<>();
	private Background background;
	private Gender gender;
	private boolean useStartingWealth;

	@Inject
	public CharacterBuilder(final NumberService numberService, final HeightAndWeightBuilder heightAndWeightBuilder,
			final AgeBuilder ageBuilder, final LanguageBuilder languageBuilder, final AbilitiesBuilder abilitiesBuilder,
			final ProficiencyBuilder proficiencyBuilder, final StartingEquipmentBuilder startingEquipmentBuilder,
			final BackgroundBuilder backgroundBuilder, final StartingWealthBuilder startingWealthBuilder) {
		genderComparator = new RandomComparator<>(numberService);
		backgroundComparator = new RandomComparator<>(numberService);
		this.abilitiesBuilder = abilitiesBuilder;
		this.ageBuilder = ageBuilder;
		this.backgroundBuilder = backgroundBuilder;
		this.heightAndWeightBuilder = heightAndWeightBuilder;
		this.languageBuilder = languageBuilder;
		this.proficiencyBuilder = proficiencyBuilder;
		this.startingEquipmentBuilder = startingEquipmentBuilder;
		this.startingWealthBuilder = startingWealthBuilder;
	}

	public Character build() throws CharacterBuilderException {
		if (race == null) {
			throw new CharacterBuilderException("No race specified for this character.");
		}
		if (abilityMods.size() > race.getAdditionalMods()) {
			throw new CharacterBuilderException(
					format("The selected race only allows {0} ability score modifiers", race.getAdditionalMods()));
		}
		if (classLevels.isEmpty()) {
			throw new CharacterBuilderException("No class specified for this character.");
		}

		final Character character = new Character();

		heightAndWeightBuilder.withHeight(race.getHeight()).withWeight(race.getWeight());
		ageBuilder.withAge(race.getAge());
		languageBuilder.withKnownLanguages(race.getKnownLanguages()).withLanguages(languages)
				.withAdditionalLanguages(race.getAdditionalLanguages());
		abilitiesBuilder.withAbilityScores(abilityScores);
		proficiencyBuilder.withToolProficiencies(race.getToolProficiencies())
				.withNumberToolProfifiencies(race.getNumberToolProficiencies());

		if (background == null) {
			background = Backgrounds.backgroundList.stream().sorted(backgroundComparator).findFirst().get();
		}
		backgroundBuilder.withBackground(background);

		final CharacterClass characterClass = classLevels.keySet().stream().findFirst().get();
		if (!useStartingWealth) {
			final List<CharacterItem> startingItems = startingEquipmentBuilder
					.withStartingEquipment(characterClass.getStartingEquipment())
					.withStartingEquipment(background.getStartingEquipment()).build();
			character.getEquipment().addAll(startingItems);
			character.getMoney().addMoney(background.getMoney());
		} else {
			final Money startingMoney = startingWealthBuilder.withStartingWealth(characterClass.getStartingWealth())
					.build();
			character.getMoney().addMoney(startingMoney);
		}

		if (gender == null) {
			gender = Stream.of(Gender.values()).sorted(genderComparator).findFirst().get();
		}

		final int height = heightAndWeightBuilder.buildHeight();
		final int weight = heightAndWeightBuilder.buildWeight();
		final int age = ageBuilder.build();
		final List<Language> languages = languageBuilder.build();
		final Map<Ability, Integer> map = abilitiesBuilder.build();
		final List<Tool> toolProficiencies = proficiencyBuilder.buildToolProficiencies();
		final String personalityTrait = backgroundBuilder.buildPersonalityTrait();
		final String ideal = backgroundBuilder.buildIdeal();
		final String bond = backgroundBuilder.buildBond();
		final String flaw = backgroundBuilder.buildFlaw();

		character.setHeight(height);
		character.setWeight(weight);
		character.setRace(race);
		character.getAbilityScores().putAll(map);
		character.getAbilityMods().putAll(abilityMods);
		character.setAge(age);
		character.getLanguages().addAll(languages);
		character.setSize(race.getSize());
		character.getSpeed().putAll(race.getMovementSpeeds());
		character.getSenses().putAll(race.getSenses());
		character.getDamageImmunities().addAll(race.getDamageImmunities());
		character.getDamageResistances().addAll(race.getDamageResistances());
		character.getProficientTools().addAll(toolProficiencies);
		character.getProficientWeapons().addAll(race.getWeaponProficiencies());
		character.getProficientWeaponTypes().addAll(race.getWeaponTypeProficiencies());
		character.getProficientArmours().addAll(race.getArmourProficiencies());
		character.getProficientArmourTypes().addAll(race.getArmourTypeProficiencies());
		character.setPersonalityTrait(personalityTrait);
		character.setIdeal(ideal);
		character.setBond(bond);
		character.setFlaw(flaw);
		character.setGender(gender);
		return character;
	}

	public CharacterBuilder withRace(final Race race) {
		this.race = race;
		return this;
	}

	public CharacterBuilder withAbilityModifier(final Ability ability, final int mod) throws CharacterBuilderException {
		if (race.getAbilityMods().containsKey(ability) || abilityMods.containsKey(ability)) {
			throw new CharacterBuilderException("A modifier for this ability has already been added.");
		}
		abilityMods.put(ability, mod);
		return this;
	}

	public CharacterBuilder withAbilityScore(final Ability ability, final int value) {
		abilityScores.put(ability, value);
		return this;
	}

	public CharacterBuilder withLanguage(final Language language) throws CharacterBuilderException {
		if (languages.contains(language) || race.getKnownLanguages().contains(language)) {
			throw new CharacterBuilderException("That language is already known.");
		}
		if (languages.size() > race.getAdditionalLanguages()) {
			throw new CharacterBuilderException(
					format("You can only choose {0} additional languages.", race.getAdditionalLanguages()));
		}
		languages.add(language);
		return this;
	}

	public CharacterBuilder withClassAndLevel(final CharacterClass characterClass, final int level) {
		classLevels.put(characterClass, level);
		return this;
	}

	public CharacterBuilder withBackground(final Background background) {
		this.background = background;
		return this;
	}

	public CharacterBuilder withGender(final Gender gender) {
		this.gender = gender;
		return this;
	}

	public CharacterBuilder withUsingStartingWealth() {
		useStartingWealth = true;
		return this;
	}
}
