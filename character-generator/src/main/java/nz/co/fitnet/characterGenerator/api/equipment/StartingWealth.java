package nz.co.fitnet.characterGenerator.api.equipment;

public class StartingWealth {
	private int numDice;
	private int diceSides;
	private int multiplier;
	private String coinType;

	@SuppressWarnings("unused")
	private StartingWealth() {
	}

	public StartingWealth(final int numDice, final int diceSides) {
		this(numDice, diceSides, 1);
	}

	public StartingWealth(final int numDice, final int diceSides, final int multiplier) {
		this(numDice, diceSides, multiplier, "gp");
	}

	public StartingWealth(final int numDice, final int diceSides, final String coinType) {
		this(numDice, diceSides, 1, coinType);
	}

	public StartingWealth(final int numDice, final int diceSides, final int multiplier, final String coinType) {
		this.numDice = numDice;
		this.diceSides = diceSides;
		this.multiplier = multiplier;
		this.coinType = coinType;
	}

	public int getNumDice() {
		return numDice;
	}

	public int getDiceSides() {
		return diceSides;
	}

	public int getMultiplier() {
		return multiplier;
	}

	@Override
	public String toString() {
		return numDice + "d" + diceSides + (multiplier > 1 ? "*" + multiplier : "") + coinType;
	}

	public String getCoinType() {
		return coinType;
	}
}
