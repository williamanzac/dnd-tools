package nz.co.fitnet.characterGenerator.core.builders;

import static nz.co.fitnet.characterGenerator.api.Language.Common;
import static nz.co.fitnet.characterGenerator.api.Language.Dwarvish;
import static nz.co.fitnet.characterGenerator.api.MovementType.walk;
import static nz.co.fitnet.characterGenerator.api.Sense.Darkvision;
import static nz.co.fitnet.characterGenerator.api.Size.Medium;
import static nz.co.fitnet.characterGenerator.data.Backgrounds.ACOLYTE;
import static nz.co.fitnet.characterGenerator.data.Classes.BARBARIAN;
import static nz.co.fitnet.characterGenerator.data.Gear.BLOCK_OF_INCENSE;
import static nz.co.fitnet.characterGenerator.data.Packs.EXPLORERS_PACK;
import static nz.co.fitnet.characterGenerator.data.Weapons.JAVELIN;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Character;
import nz.co.fitnet.characterGenerator.core.builders.CharacterBuilder.CharacterBuilderException;
import nz.co.fitnet.characterGenerator.data.equipment.gear.holysymbol.HolySymbol;
import nz.co.fitnet.characterGenerator.data.races.HillDwarf;
import nz.co.fitnet.characterGenerator.data.races.Human;
import nz.co.fitnet.characterGenerator.data.races.MountainDwarf;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class CharacterBuilderTest {
	private CharacterBuilder characterBuilder;
	private HeightAndWeightBuilder heightAndWeightBuilder;
	private NumberGenerator numberService;
	private AgeBuilder ageBuilder;
	private LanguageBuilder languageBuilder;
	private AbilitiesBuilder abilitiesBuilder;
	private ProficiencyBuilder proficiencyBuilder;
	private StartingEquipmentBuilder startingEquipmentBuilder;
	private BackgroundBuilder backgroundBuilder;
	private StartingWealthBuilder startingWealthBuilder;

	@Before
	public void setup() {
		numberService = new NumberGenerator();

		heightAndWeightBuilder = new HeightAndWeightBuilder(numberService);

		ageBuilder = new AgeBuilder(numberService);

		languageBuilder = new LanguageBuilder(numberService);

		abilitiesBuilder = new AbilitiesBuilder(numberService);

		proficiencyBuilder = new ProficiencyBuilder(numberService);

		startingEquipmentBuilder = new StartingEquipmentBuilder(numberService);

		backgroundBuilder = new BackgroundBuilder(numberService);

		startingWealthBuilder = new StartingWealthBuilder(numberService);

		characterBuilder = new CharacterBuilder(numberService, heightAndWeightBuilder, ageBuilder, languageBuilder,
				abilitiesBuilder, proficiencyBuilder, startingEquipmentBuilder, backgroundBuilder,
				startingWealthBuilder);
	}

	@Test
	public void verifyHumanCharacter() throws CharacterBuilderException {
		final Human human = new Human();
		final Character character = characterBuilder.withRace(human).withClassAndLevel(BARBARIAN, 1)
				.withBackground(ACOLYTE).withUsingStartingWealth().build();
		character.getHeight();
		character.getWeight();
		character.getAge();
		character.getAbilityMods();
		character.getAbilityScores();
		for (final Ability ability : Ability.values()) {
			character.getAbilityScore(ability);
			character.getAbilityScoreModifier(ability);
		}
		System.out.println(character.getMoney());
		assertThat(character.getKnownLanguages().size(), is(equalTo(2)));
		assertThat(character.getKnownLanguages().get(0), is(equalTo(Common)));
		assertThat(character.getLanguages().size(), is(equalTo(1)));
		assertThat(character.getMovementSpeed(walk), is(equalTo(30)));
		assertThat(character.getSize(), is(equalTo(Medium)));
		assertThat(character.getMoney().getGold(), allOf(greaterThanOrEqualTo(20), lessThanOrEqualTo(80)));
		assertThat(character.getEquipment(), empty());
	}

	@Test
	public void verifyHillDwarfCharacter() throws CharacterBuilderException {
		final HillDwarf hillDwarf = new HillDwarf();
		final Character character = characterBuilder.withRace(hillDwarf).withClassAndLevel(BARBARIAN, 1)
				.withBackground(ACOLYTE).build();
		character.getHeight();
		character.getWeight();
		character.getAge();
		character.getAbilityMods();
		character.getAbilityScores();
		for (final Ability ability : Ability.values()) {
			character.getAbilityScore(ability);
			character.getAbilityScoreModifier(ability);
		}
		assertThat(character.getKnownLanguages(), containsInAnyOrder(Common, Dwarvish));
		assertThat(character.getLanguages().size(), is(equalTo(0)));
		assertThat(character.getMovementSpeed(walk), is(equalTo(25)));
		assertThat(character.getSize(), is(equalTo(Medium)));
		assertThat(character.getSense(Darkvision), is(equalTo(60)));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() == EXPLORERS_PACK));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() == JAVELIN && i.getQuantity() == 4));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() instanceof HolySymbol));
		assertTrue(character.getEquipment().stream()
				.anyMatch(i -> i.getItem() == BLOCK_OF_INCENSE && i.getQuantity() == 5));
	}

	@Test
	public void verifyMountainDwarfCharacter() throws CharacterBuilderException {
		final MountainDwarf mountainDwarf = new MountainDwarf();
		final Character character = characterBuilder.withRace(mountainDwarf).withClassAndLevel(BARBARIAN, 1)
				.withBackground(ACOLYTE).build();
		character.getHeight();
		character.getWeight();
		character.getAge();
		character.getAbilityMods();
		character.getAbilityScores();
		for (final Ability ability : Ability.values()) {
			character.getAbilityScore(ability);
			character.getAbilityScoreModifier(ability);
		}
		assertThat(character.getKnownLanguages(), containsInAnyOrder(Common, Dwarvish));
		assertThat(character.getLanguages().size(), is(equalTo(0)));
		assertThat(character.getMovementSpeed(walk), is(equalTo(25)));
		assertThat(character.getSize(), is(equalTo(Medium)));
		assertThat(character.getSense(Darkvision), is(equalTo(60)));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() == EXPLORERS_PACK));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() == JAVELIN && i.getQuantity() == 4));
		assertTrue(character.getEquipment().stream().anyMatch(i -> i.getItem() instanceof HolySymbol));
		assertTrue(character.getEquipment().stream()
				.anyMatch(i -> i.getItem() == BLOCK_OF_INCENSE && i.getQuantity() == 5));
	}
}
