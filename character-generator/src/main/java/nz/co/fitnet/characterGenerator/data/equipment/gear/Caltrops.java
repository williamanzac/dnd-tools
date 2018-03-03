package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;
import nz.co.fitnet.characterGenerator.data.equipment.gear.container.Bag;

public class Caltrops extends Bag implements ItemQuantity {
	private final int quantity;

	public Caltrops() {
		super(2, 1);
		quantity = 20;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
