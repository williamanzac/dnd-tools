package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.BALL_BEARING;
import static nz.co.fitnet.characterGenerator.data.Gear.BELL;
import static nz.co.fitnet.characterGenerator.data.Gear.CANDLE;
import static nz.co.fitnet.characterGenerator.data.Gear.CROWBAR;
import static nz.co.fitnet.characterGenerator.data.Gear.HAMMER;
import static nz.co.fitnet.characterGenerator.data.Gear.HEMPEN_ROPE;
import static nz.co.fitnet.characterGenerator.data.Gear.HOODED_LANTERN;
import static nz.co.fitnet.characterGenerator.data.Gear.OIL;
import static nz.co.fitnet.characterGenerator.data.Gear.PITON;
import static nz.co.fitnet.characterGenerator.data.Gear.RATIONS;
import static nz.co.fitnet.characterGenerator.data.Gear.STRING;
import static nz.co.fitnet.characterGenerator.data.Gear.TINDERBOX;
import static nz.co.fitnet.characterGenerator.data.Gear.WATERSKIN;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class BurglarsPack extends Pack {
	public BurglarsPack() {
		super(16, BACKPACK, BALL_BEARING, STRING, BELL, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CROWBAR, HAMMER, PITON,
				PITON, PITON, PITON, PITON, PITON, PITON, PITON, PITON, PITON, HOODED_LANTERN, OIL, OIL, RATIONS,
				RATIONS, RATIONS, RATIONS, RATIONS, TINDERBOX, WATERSKIN, HEMPEN_ROPE);
	}
}
