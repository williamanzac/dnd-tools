package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.BEDROLL;
import static nz.co.fitnet.characterGenerator.data.Gear.HEMPEN_ROPE;
import static nz.co.fitnet.characterGenerator.data.Gear.MESS_KIT;
import static nz.co.fitnet.characterGenerator.data.Gear.RATIONS;
import static nz.co.fitnet.characterGenerator.data.Gear.TINDERBOX;
import static nz.co.fitnet.characterGenerator.data.Gear.TORCH;
import static nz.co.fitnet.characterGenerator.data.Gear.WATERSKIN;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class ExplorersPack extends Pack {
	public ExplorersPack() {
		super(10, BACKPACK, BEDROLL, MESS_KIT, TINDERBOX, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH,
				TORCH, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS,
				WATERSKIN, HEMPEN_ROPE);
	}
}
