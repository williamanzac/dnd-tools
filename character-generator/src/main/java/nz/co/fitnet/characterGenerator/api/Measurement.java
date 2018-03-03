package nz.co.fitnet.characterGenerator.api;

public class Measurement {
	private int base;
	private String modifier;

	@SuppressWarnings("unused")
	private Measurement() {
	}
	
	public Measurement(final int base, final String modifier) {
		super();
		this.base = base;
		this.modifier = modifier;
	}

	public int getBase() {
		return base;
	}

	public void setBase(final int base) {
		this.base = base;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(final String modifier) {
		this.modifier = modifier;
	}
}
