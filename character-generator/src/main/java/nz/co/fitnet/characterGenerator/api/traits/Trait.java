package nz.co.fitnet.characterGenerator.api.traits;

public abstract class Trait<T> {
	private TraitType type;
	private T thing;

	public Trait(final TraitType type, final T thing) {
		super();
		this.type = type;
		this.thing = thing;
	}

	public String getName() {
		return getClass().getSimpleName().replace("Trait", "");
	}

	public TraitType getType() {
		return type;
	}

	public void setType(final TraitType type) {
		this.type = type;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(final T thing) {
		this.thing = thing;
	}
}
