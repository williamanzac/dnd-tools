package nz.co.fitnet.characterGenerator.api.equipment;

public abstract class Lifestyle {

	private final double price;
	private final boolean minimum;

	public Lifestyle(final double price) {
		this(price, false);
	}

	public Lifestyle(final double price, final boolean minimum) {
		this.price = price;
		this.minimum = minimum;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return getClass().getSimpleName();
	}

	public boolean isMinimum() {
		return minimum;
	}
}
