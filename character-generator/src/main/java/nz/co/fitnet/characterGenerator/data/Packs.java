package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Pack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.BurglarsPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.DiplomatsPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.DungeoneersPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.EntertainersPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.ExplorersPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.PriestsPack;
import nz.co.fitnet.characterGenerator.data.equipment.packs.ScholarsPack;

public class Packs {
	public static final BurglarsPack BURGLARS_PACK = new BurglarsPack();
	public static final DiplomatsPack DIPLOMATS_PACK = new DiplomatsPack();
	public static final DungeoneersPack DUNGEONEERS_PACK = new DungeoneersPack();
	public static final EntertainersPack ENTERTAINERS_PACK = new EntertainersPack();
	public static final ExplorersPack EXPLORERS_PACK = new ExplorersPack();
	public static final PriestsPack PRIESTS_PACK = new PriestsPack();
	public static final ScholarsPack SCHOLARS_PACK = new ScholarsPack();

	public static final List<Pack> packList = asList(BURGLARS_PACK, DIPLOMATS_PACK, DUNGEONEERS_PACK, ENTERTAINERS_PACK,
			EXPLORERS_PACK, PRIESTS_PACK, SCHOLARS_PACK);
}
