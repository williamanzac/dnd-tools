package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;

public class HempenRope extends Item implements ItemQuantity {
	private final int quantity;

	public HempenRope() {
		super(10, 1);
		quantity = 50;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
