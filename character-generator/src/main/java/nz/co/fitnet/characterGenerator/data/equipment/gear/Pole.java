package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public class Pole extends Item implements ItemQuantity {
	private final int quantity;

	public Pole() {
		super(7, 0.05);
		quantity = 10;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
