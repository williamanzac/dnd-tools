package nz.co.fitnet.characterGenerator.data.equipment.packs;

import static nz.co.fitnet.characterGenerator.data.Gear.BACKPACK;
import static nz.co.fitnet.characterGenerator.data.Gear.BEDROLL;
import static nz.co.fitnet.characterGenerator.data.Gear.CANDLE;
import static nz.co.fitnet.characterGenerator.data.Gear.COSTUME_CLOTHES;
import static nz.co.fitnet.characterGenerator.data.Gear.RATIONS;
import static nz.co.fitnet.characterGenerator.data.Gear.WATERSKIN;
import static nz.co.fitnet.characterGenerator.data.Tools.DISGUISE_KIT;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;

public class EntertainersPack extends Pack {
	public EntertainersPack() {
		super(40, BACKPACK, BEDROLL, COSTUME_CLOTHES, COSTUME_CLOTHES, CANDLE, CANDLE, CANDLE, CANDLE, CANDLE, RATIONS,
				RATIONS, RATIONS, RATIONS, RATIONS, WATERSKIN, DISGUISE_KIT);
	}
}
