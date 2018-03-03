package nz.co.fitnet.characterGenerator.api.equipment;

public abstract class Item {
	private final double weight;
	private final double cost; // gp

	public Item(final double weight, final double cost) {
		this.weight = weight;
		this.cost = cost;
	}

	public String getName() {
		return getClass().getSimpleName();
	}

	public double getWeight() {
		return weight;
	}

	public double getCost() {
		return cost;
	}
}
