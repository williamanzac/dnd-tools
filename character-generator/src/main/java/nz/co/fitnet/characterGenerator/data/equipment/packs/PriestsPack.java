package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.ALMS_BOX;
import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.BLANKET;
import static nz.co.fitnet.characterGenerator.data.Gear.BLOCK_OF_INCENSE;
import static nz.co.fitnet.characterGenerator.data.Gear.CANDLE;
import static nz.co.fitnet.characterGenerator.data.Gear.CENSER;
import static nz.co.fitnet.characterGenerator.data.Gear.RATIONS;
import static nz.co.fitnet.characterGenerator.data.Gear.TINDERBOX;
import static nz.co.fitnet.characterGenerator.data.Gear.VESTMENTS;
import static nz.co.fitnet.characterGenerator.data.Gear.WATERSKIN;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class PriestsPack extends Pack {
	public PriestsPack() {
		super(19, BACKPACK, BLANKET, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE,
				TINDERBOX, ALMS_BOX, BLOCK_OF_INCENSE, BLOCK_OF_INCENSE, CENSER, VESTMENTS, RATIONS, RATIONS,
				WATERSKIN);
	}
}
