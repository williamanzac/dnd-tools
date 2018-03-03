package nz.co.fitnet.characterGenerator.data.equipment.gear.container;

public abstract class Bottle extends Container {
	public Bottle(final double weight, final double cost) {
		this(weight, cost, "1 1/2 pints liquid");
	}

	public Bottle(final double weight, final double cost, final String capacity) {
		super(weight, cost, capacity);
	}
}
