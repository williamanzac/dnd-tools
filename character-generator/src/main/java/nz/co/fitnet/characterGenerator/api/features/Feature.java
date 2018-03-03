package nz.co.fitnet.characterGenerator.api.features;

public abstract class Feature {
	private int level;

	public Feature(final int level) {
		this.level = level;
	}

	public String getName() {
		return getClass().getSimpleName();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}
}
