package nz.co.fitnet.characterGenerator.api.equipment;

public class WeaponRange {
	private int from;
	private int to;

	public WeaponRange(final int from, final int to) {
		super();
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(final int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(final int to) {
		this.to = to;
	}
}
