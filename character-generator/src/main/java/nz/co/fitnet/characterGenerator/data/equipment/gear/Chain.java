package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public class Chain extends Item implements ItemQuantity {
	private final int quantity;

	public Chain() {
		super(10, 5);
		quantity = 10;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
