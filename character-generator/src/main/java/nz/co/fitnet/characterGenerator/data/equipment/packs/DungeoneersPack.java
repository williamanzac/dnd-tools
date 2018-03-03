package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.CROWBAR;
import static nz.co.fitnet.characterGenerator.data.Gear.HAMMER;
import static nz.co.fitnet.characterGenerator.data.Gear.HEMPEN_ROPE;
import static nz.co.fitnet.characterGenerator.data.Gear.PITON;
import static nz.co.fitnet.characterGenerator.data.Gear.RATIONS;
import static nz.co.fitnet.characterGenerator.data.Gear.TINDERBOX;
import static nz.co.fitnet.characterGenerator.data.Gear.TORCH;
import static nz.co.fitnet.characterGenerator.data.Gear.WATERSKIN;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class DungeoneersPack extends Pack {
	public DungeoneersPack() {
		super(12, BACKPACK, CROWBAR, HAMMER, PITON, PITON, PITON, PITON, PITON, PITON, PITON, PITON, PITON, PITON,
				TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TORCH, TINDERBOX, RATIONS, RATIONS,
				RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, RATIONS, WATERSKIN, HEMPEN_ROPE);
	}
}
