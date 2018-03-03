package nz.co.fitnet.characterGenerator.data.equipment.gear.container;

import nz.co.fitnet.characterGenerator.api.equipment.Item;

public class Container extends Item {
	private final String capacity;

	public Container(final double weight, final double cost, final String capacity) {
		super(weight, cost);
		this.capacity = capacity;
	}

	public String getCapacity() {
		return capacity;
	}
}
