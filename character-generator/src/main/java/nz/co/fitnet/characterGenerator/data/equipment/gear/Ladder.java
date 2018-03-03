package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public class Ladder extends Item implements ItemQuantity {
	private final int quantity;

	public Ladder() {
		super(25, 0.01);
		quantity = 10;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
