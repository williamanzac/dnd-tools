package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public class String extends Item implements ItemQuantity {
	private final int quantity;

	public String() {
		super(0, 0);
		quantity = 10;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
