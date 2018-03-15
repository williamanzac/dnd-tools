package nz.co.fitnet.characterGenerator.api.equipment;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Pack extends Item {
	private final List<Item> items = new ArrayList<>();

	public Pack(final double cost, final Item... items) {
		super(0, cost);
		this.items.addAll(asList(items));
	}

	@Override
	public double getWeight() {// sum of the contents
		final Double weight = items.stream().map(Item::getWeight).reduce((t, n) -> t + n).orElse(0d);
		return weight;
	}

	public List<Item> getItems() {
		return items;
	}
}
