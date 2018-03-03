package nz.co.fitnet.characterGenerator.core.builders;

import static nz.co.fitnet.characterGenerator.data.Backgrounds.ACOLYTE;
import static nz.co.fitnet.characterGenerator.data.Classes.BARBARIAN;
import static nz.co.fitnet.characterGenerator.data.Gear.BLOCK_OF_INCENSE;
import static nz.co.fitnet.characterGenerator.data.Packs.EXPLORERS_PACK;
import static nz.co.fitnet.characterGenerator.data.Weapons.JAVELIN;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.equipment.CharacterItem;
import nz.co.fitnet.characterGenerator.data.equipment.gear.holysymbol.HolySymbol;
import nz.co.fitnet.numberGenerator.api.NumberService;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class StartingEquipmentBuilderTest {
	private NumberService numberService;
	private StartingEquipmentBuilder startingEquipmentBuilder;

	@Before
	public void setup() {
		numberService = new NumberGenerator();

		startingEquipmentBuilder = new StartingEquipmentBuilder();
		startingEquipmentBuilder.setNumberService(numberService);
	}

	@Test
	public void verifyBarbarianEquipment() {
		startingEquipmentBuilder.withStartingEquipment(BARBARIAN.getStartingEquipment())
				.withStartingEquipment(ACOLYTE.getStartingEquipment());
		final List<CharacterItem> actual = startingEquipmentBuilder.build();
		System.out.println(actual);
		assertThat(actual.size(), equalTo(9));
		assertTrue(actual.stream().anyMatch(i -> i.getItem() == EXPLORERS_PACK));
		assertTrue(actual.stream().anyMatch(i -> i.getItem() == JAVELIN && i.getQuantity() == 4));
		assertTrue(actual.stream().anyMatch(i -> i.getItem() instanceof HolySymbol));
		assertTrue(actual.stream().anyMatch(i -> i.getItem() == BLOCK_OF_INCENSE && i.getQuantity() == 5));
	}
}
