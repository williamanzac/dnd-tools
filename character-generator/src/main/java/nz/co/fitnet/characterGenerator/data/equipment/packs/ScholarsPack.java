package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.BOOK;
import static nz.co.fitnet.characterGenerator.data.Gear.INK;
import static nz.co.fitnet.characterGenerator.data.Gear.INK_PEN;
import static nz.co.fitnet.characterGenerator.data.Gear.LITTLE_BAG_OF_SAND;
import static nz.co.fitnet.characterGenerator.data.Gear.PARCHMENT;
import static nz.co.fitnet.characterGenerator.data.Gear.SMALL_KNIFE;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class ScholarsPack extends Pack {
	public ScholarsPack() {
		super(40, BACKPACK, BOOK, INK, INK_PEN, PARCHMENT, PARCHMENT, PARCHMENT, PARCHMENT, PARCHMENT, PARCHMENT,
				PARCHMENT, PARCHMENT, PARCHMENT, PARCHMENT, LITTLE_BAG_OF_SAND, SMALL_KNIFE);
	}
}
