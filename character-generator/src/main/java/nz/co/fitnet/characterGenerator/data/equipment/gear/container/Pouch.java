package nz.co.fitnet.characterGenerator.data.equipment.gear.container;

public class Pouch extends Container {
	public Pouch() {
		this(1, 0.5);
	}

	public Pouch(final double weight, final double cost) {
		super(weight, cost, "1/5 cubic foot/6 pounds of gear");
	}
}
