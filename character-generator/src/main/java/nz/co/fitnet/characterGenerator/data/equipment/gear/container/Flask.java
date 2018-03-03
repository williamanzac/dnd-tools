package nz.co.fitnet.characterGenerator.data.equipment.gear.container;

public class Flask extends Container {
	public Flask() {
		this(1, 2);
	}

	public Flask(final double weight, final double cost) {
		super(weight, cost, "1 pint liquid");
	}
}
