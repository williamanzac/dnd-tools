package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.equipment.CharacterItem;
import nz.co.fitnet.characterGenerator.api.equipment.EquipmentOption;
import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.Pack;
import nz.co.fitnet.characterGenerator.api.equipment.StartingEquipment;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class StartingEquipmentBuilder {
	private final RandomComparator<Item> itemComparator;
	private final RandomComparator<EquipmentOption> equipmentOptionComparator;

	private final List<StartingEquipment> startingEquipment = new ArrayList<>();

	@Inject
	public StartingEquipmentBuilder(final NumberService numberService) {
		itemComparator = new RandomComparator<>(numberService);
		equipmentOptionComparator = new RandomComparator<>(numberService);
	}

	public StartingEquipmentBuilder withStartingEquipment(final StartingEquipment startingEquipment) {
		this.startingEquipment.add(startingEquipment);
		return this;
	}

	private void addItems(final Map<Item, CharacterItem> itemMap, final List<Item> items) {
		items.forEach(item -> {
			if (item instanceof Pack) {
				addItems(itemMap, ((Pack) item).getItems());
			} else if (itemMap.containsKey(item)) {
				final CharacterItem characterItem = itemMap.get(item);
				characterItem.setQuantity(characterItem.getQuantity() + 1);
			} else {
				itemMap.put(item, new CharacterItem(item, 1));
			}
		});
	}

	private List<Item> getItemsForOption(final EquipmentOption option) {
		final List<Item> items = new ArrayList<>();
		final int numberOfChoices = option.getNumberOfChoices();
		if (numberOfChoices == 0) {
			items.addAll(option.getItems());
			final List<Item> list = option.getOptions().stream().map(o -> getItemsForOption(o)).flatMap(List::stream)
					.collect(toList());
			items.addAll(list);
		} else {
			if (!option.getItems().isEmpty()) {
				final List<Item> list = option.getItems().stream().sorted(itemComparator).limit(numberOfChoices)
						.collect(toList());
				items.addAll(list);
			} else {
				final List<Item> list = option.getOptions().stream().sorted(equipmentOptionComparator)
						.limit(numberOfChoices).map(o -> getItemsForOption(o)).flatMap(List::stream).collect(toList());
				items.addAll(list);
			}
		}
		return items;
	}

	public List<CharacterItem> build() {
		final List<CharacterItem> items = new ArrayList<>();
		final Map<Item, CharacterItem> itemMap = new HashMap<>();
		startingEquipment.stream().map(StartingEquipment::getOptions).flatMap(Collection::stream)
				.map(o -> getItemsForOption(o)).forEach(l -> addItems(itemMap, l));
		items.addAll(itemMap.values());
		return items;
	}
}
