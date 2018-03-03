package nz.co.fitnet.characterGenerator.data.equipment.gear.ammunition;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public abstract class Ammunition extends Item implements ItemQuantity {
	private final int quantity;

	public Ammunition(final double weight, final double cost, final int quantity) {
		super(weight, cost);
		this.quantity = quantity;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
