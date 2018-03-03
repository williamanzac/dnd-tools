package nz.co.fitnet.characterGenerator.api.equipment;

public class CharacterItem {
	private Item item;
	private int quantity;
	private boolean equipped;

	public CharacterItem(final Item item, final int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(final Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public boolean isEquipped() {
		return equipped;
	}

	public void setEquipped(final boolean equipped) {
		this.equipped = equipped;
	}

	@Override
	public String toString() {
		return "CharacterItem [item=" + item.getClass().getSimpleName() + ", quantity=" + quantity + ", equipped="
				+ equipped + "]";
	}
}
