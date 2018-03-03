package nz.co.fitnet.characterGenerator.api.equipment;

public abstract class Armour extends Item {
	private ArmourType type;
	private int ac;
	private boolean plusDex;
	private boolean stealthDisadvantage;
	private int strength;

	public Armour(final ArmourType type, final int ac, final boolean plusDex, final boolean stealthDisadvantage,
			final int strength, final int weight, final int cost) {
		super(weight, cost);
		this.type = type;
		this.ac = ac;
		this.plusDex = plusDex;
		this.stealthDisadvantage = stealthDisadvantage;
		this.strength = strength;
	}

	public ArmourType getType() {
		return type;
	}

	public void setType(final ArmourType type) {
		this.type = type;
	}

	public int getAC() {
		return ac;
	}

	public void setAC(final int ac) {
		this.ac = ac;
	}

	public boolean isPlusDex() {
		return plusDex;
	}

	public void setPlusDex(final boolean plusDex) {
		this.plusDex = plusDex;
	}

	public boolean isStealthDisadvantage() {
		return stealthDisadvantage;
	}

	public void setStealthDisadvantage(final boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(final int strength) {
		this.strength = strength;
	}
}
