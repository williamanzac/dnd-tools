package nz.co.fitnet.characterGenerator.api;

public class Speed {
	private MovementType type;
	private int speed;

	public Speed(final MovementType type, final int speed) {
		super();
		this.type = type;
		this.speed = speed;
	}

	public MovementType getType() {
		return type;
	}

	public void setType(final MovementType type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(final int speed) {
		this.speed = speed;
	}
}
