package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.co.fitnet.characterGenerator.api.equipment.CharacterItem;
import nz.co.fitnet.characterGenerator.api.equipment.EquipmentOption;
import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.StartingEquipment;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class StartingEquipmentBuilder {
	private static final RandomCompator<Item> ITEM_COMPARATOR = new RandomCompator<>();
	private static final RandomCompator<EquipmentOption> EQUIPMENT_OPTION_COMPARATOR = new RandomCompator<>();

	private final List<StartingEquipment> startingEquipment = new ArrayList<>();

	public StartingEquipmentBuilder withStartingEquipment(final StartingEquipment startingEquipment) {
		this.startingEquipment.add(startingEquipment);
		return this;
	}

	private void addItems(final Map<Item, CharacterItem> itemMap, final List<Item> items) {
		items.forEach(item -> {
			if (itemMap.containsKey(item)) {
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
			for (final EquipmentOption o : option.getOptions()) {
				final List<Item> itemsForOption = getItemsForOption(o);
				items.addAll(itemsForOption);
			}
		} else {
			if (!option.getItems().isEmpty()) {
				final List<Item> list = option.getItems().stream().sorted(ITEM_COMPARATOR).limit(numberOfChoices)
						.collect(toList());
				items.addAll(list);
			} else {
				final List<EquipmentOption> list = option.getOptions().stream().sorted(EQUIPMENT_OPTION_COMPARATOR)
						.limit(numberOfChoices).collect(toList());
				list.forEach(o -> {
					final List<Item> itemsForOption = getItemsForOption(o);
					items.addAll(itemsForOption);
				});
			}
		}
		return items;
	}

	public List<CharacterItem> build() {
		final List<CharacterItem> items = new ArrayList<>();
		final Map<Item, CharacterItem> itemMap = new HashMap<>();
		startingEquipment.stream().map(StartingEquipment::getOptions).flatMap(Collection::stream).forEach(option -> {
			final List<Item> itemsForOption = getItemsForOption(option);
			addItems(itemMap, itemsForOption);
		});
		items.addAll(itemMap.values());
		return items;
	}

	void setNumberService(final NumberService numberService) {
		ITEM_COMPARATOR.setNumberService(numberService);
		EQUIPMENT_OPTION_COMPARATOR.setNumberService(numberService);
	}
}
