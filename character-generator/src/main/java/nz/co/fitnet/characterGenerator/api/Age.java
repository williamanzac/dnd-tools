package nz.co.fitnet.characterGenerator.api;

public class Age {
	private int maturity;
	private int max;

	@SuppressWarnings("unused")
	private Age() {
	}

	public Age(final int maturity, final int max) {
		this.maturity = maturity;
		this.max = max;
	}

	public int getMaturity() {
		return maturity;
	}

	public void setMaturity(final int maturity) {
		this.maturity = maturity;
	}

	public int getMax() {
		return max;
	}

	public void setMax(final int max) {
		this.max = max;
	}
}
