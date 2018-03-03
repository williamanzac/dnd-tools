package nz.co.fitnet.characterGenerator.api.equipment;

public class Money {
	private int platinum;
	private int gold;
	private int electrum;
	private int silver;
	private int copper;

	public Money() {
	}

	public Money(final int platinum, final int gold, final int electrum, final int silver, final int copper) {
		this.platinum = platinum;
		this.gold = gold;
		this.electrum = electrum;
		this.silver = silver;
		this.copper = copper;
	}

	public int getPlatinum() {
		return platinum;
	}

	public void setPlatinum(final int platinum) {
		this.platinum = platinum;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(final int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(final int silver) {
		this.silver = silver;
	}

	public int getCopper() {
		return copper;
	}

	public void setCopper(final int copper) {
		this.copper = copper;
	}

	public void addCopper(final int copper) {
		this.copper += copper;
	}

	public void addSilver(final int silver) {
		this.silver += silver;
	}

	public void addGold(final int gold) {
		this.gold += gold;
	}

	public void addPlatinum(final int platinum) {
		this.platinum += platinum;
	}

	public void addMoney(final Money money) {
		platinum += money.platinum;
		gold += money.gold;
		electrum += money.electrum;
		silver += money.silver;
		copper += money.copper;
	}

	public int getElectrum() {
		return electrum;
	}

	public void setElectrum(final int electrum) {
		this.electrum = electrum;
	}

	public void addElectrum(final int electrum) {
		this.electrum += electrum;
	}

	@Override
	public String toString() {
		return "Money [pp=" + platinum + ", gp=" + gold + ", ep=" + electrum + ", sp=" + silver + ", cp=" + copper
				+ "]";
	}
}
