package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.ItemQuantity;
import nz.co.fitnet.characterGenerator.data.equipment.gear.container.Bag;

public class BallBearings extends Bag implements ItemQuantity {
	private final int quantity;

	public BallBearings() {
		super(2, 1);
		quantity = 1000;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
}
