package nz.co.fitnet.characterGenerator.api;

public class BreathWeapon {
	private DamageType damageType;
	private Ability saveType;
	private String shape;

	public BreathWeapon(final DamageType damageType, final Ability saveType, final String shape) {
		super();
		this.damageType = damageType;
		this.saveType = saveType;
		this.shape = shape;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(final DamageType damageType) {
		this.damageType = damageType;
	}

	public Ability getSaveType() {
		return saveType;
	}

	public void setSaveType(final Ability saveType) {
		this.saveType = saveType;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(final String shape) {
		this.shape = shape;
	}
}
