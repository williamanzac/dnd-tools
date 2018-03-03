package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.CHEST;
import static nz.co.fitnet.characterGenerator.data.Gear.FINE_CLOTHES;
import static nz.co.fitnet.characterGenerator.data.Gear.INK;
import static nz.co.fitnet.characterGenerator.data.Gear.INK_PEN;
import static nz.co.fitnet.characterGenerator.data.Gear.LAMP;
import static nz.co.fitnet.characterGenerator.data.Gear.OIL;
import static nz.co.fitnet.characterGenerator.data.Gear.PAPER;
import static nz.co.fitnet.characterGenerator.data.Gear.PERFUME;
import static nz.co.fitnet.characterGenerator.data.Gear.SCROLL_CASE;
import static nz.co.fitnet.characterGenerator.data.Gear.SEALING_WAX;
import static nz.co.fitnet.characterGenerator.data.Gear.SOAP;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class DiplomatsPack extends Pack {
	public DiplomatsPack() {
		super(39, CHEST, SCROLL_CASE, SCROLL_CASE, FINE_CLOTHES, INK, INK_PEN, LAMP, OIL, OIL, PAPER, PAPER, PAPER,
				PAPER, PAPER, PERFUME, SEALING_WAX, SOAP);
	}
}
