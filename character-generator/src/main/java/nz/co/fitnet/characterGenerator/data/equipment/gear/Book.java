package nz.co.fitnet.characterGenerator.data.equipment.gear;

import nz.co.fitnet.characterGenerator.api.equipment.Item;

public class Book extends Item {
	public Book() {
		this(5, 25);
	}

	public Book(final double weight, final double cost) {
		super(weight, cost);
	}
}
