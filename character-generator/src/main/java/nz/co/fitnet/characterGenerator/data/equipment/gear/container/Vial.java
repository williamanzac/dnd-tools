package nz.co.fitnet.characterGenerator.data.equipment.gear.container;

public class Vial extends Container {
	public Vial() {
		this(0, 1);
	}

	public Vial(final double weight, final double cost) {
		super(weight, cost, "4 ounces liquid");
	}
}
