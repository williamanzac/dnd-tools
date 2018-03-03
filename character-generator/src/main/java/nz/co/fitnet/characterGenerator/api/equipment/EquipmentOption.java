package nz.co.fitnet.characterGenerator.api.equipment;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class EquipmentOption {
	private final List<Item> items = new ArrayList<>();
	private final List<EquipmentOption> options = new ArrayList<>();
	private int numberOfChoices = 0;
	private String name;

	@SuppressWarnings("unused")
	private EquipmentOption() {
	}

	public EquipmentOption(final String name, final Item... items) {
		this(name, 0, items);
	}

	public EquipmentOption(final String name, final int numberOfChoices, final Item... items) {
		this(name, numberOfChoices, asList(items));
	}

	public EquipmentOption(final String name, final EquipmentOption... options) {
		this(name, 0, options);
	}

	public EquipmentOption(final String name, final int numberOfChoices, final EquipmentOption... options) {
		this.options.addAll(asList(options));
		this.numberOfChoices = numberOfChoices;
		this.name = name;
	}

	public EquipmentOption(final String name, final List<? extends Item> items) {
		this(name, 0, items);
	}

	public EquipmentOption(final String name, final int numberOfChoices, final List<? extends Item> items) {
		this.items.addAll(items);
		this.numberOfChoices = numberOfChoices;
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public int getNumberOfChoices() {
		return numberOfChoices;
	}

	public void setNumberOfChoices(final int numberOfChoices) {
		this.numberOfChoices = numberOfChoices;
	}

	public List<EquipmentOption> getOptions() {
		return options;
	}

	public String getName() {
		return name;
	}
}
