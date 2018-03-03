package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.characterGenerator.data.equipment.tools.DisguiseKit;
import nz.co.fitnet.characterGenerator.data.equipment.tools.ForgeryKit;
import nz.co.fitnet.characterGenerator.data.equipment.tools.HerbalismKit;
import nz.co.fitnet.characterGenerator.data.equipment.tools.NavigatorsTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.PoisonersKit;
import nz.co.fitnet.characterGenerator.data.equipment.tools.ThievesTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.AlchemistsSupplies;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.BrewersSupplies;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.CalligraphersSupplies;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.CarpentersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.CartographersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.CobblersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.CooksUtensils;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.GlassblowersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.JewelersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.LeatherworkersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.MasonsTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.PaintersSupplies;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.PottersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.SmithsTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.TinkersTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.WeaversTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.artisanstools.WoodcarversTools;
import nz.co.fitnet.characterGenerator.data.equipment.tools.gamingset.DiceSet;
import nz.co.fitnet.characterGenerator.data.equipment.tools.gamingset.DragonchessSet;
import nz.co.fitnet.characterGenerator.data.equipment.tools.gamingset.PlayingCardSet;
import nz.co.fitnet.characterGenerator.data.equipment.tools.gamingset.ThreeDragonAnteSet;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Bagpipes;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Drum;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Dulcimer;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Flute;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Horn;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Lute;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Lyre;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.PanFlute;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Shawm;
import nz.co.fitnet.characterGenerator.data.equipment.tools.musicalinstrument.Viol;

public class Tools {
	public static final AlchemistsSupplies ALCHEMISTS_SUPPLIES = new AlchemistsSupplies();
	public static final BrewersSupplies BREWERS_SUPPLIES = new BrewersSupplies();
	public static final CalligraphersSupplies CALLIGRAPHERS_SUPPLIES = new CalligraphersSupplies();
	public static final CarpentersTools CARPENTERS_TOOLS = new CarpentersTools();
	public static final CartographersTools CARTOGRAPHERS_TOOLS = new CartographersTools();
	public static final CobblersTools COBBLERS_TOOLS = new CobblersTools();
	public static final CooksUtensils COOKS_UTENSILS = new CooksUtensils();
	public static final GlassblowersTools GLASSBLOWERS_TOOLS = new GlassblowersTools();
	public static final JewelersTools JEWELERS_TOOLS = new JewelersTools();
	public static final LeatherworkersTools LEATHERWORKERS_TOOLS = new LeatherworkersTools();
	public static final MasonsTools MASONS_TOOLS = new MasonsTools();
	public static final PaintersSupplies PAINTERS_SUPPLIES = new PaintersSupplies();
	public static final PottersTools POTTERS_TOOLS = new PottersTools();
	public static final SmithsTools SMITHS_TOOLS = new SmithsTools();
	public static final TinkersTools TINKERS_TOOLS = new TinkersTools();
	public static final WeaversTools WEAVERS_TOOLS = new WeaversTools();
	public static final WoodcarversTools WOODCARVERS_TOOLS = new WoodcarversTools();
	public static final DisguiseKit DISGUISE_KIT = new DisguiseKit();
	public static final ForgeryKit FORGERY_KIT = new ForgeryKit();
	public static final DiceSet DICE_SET = new DiceSet();
	public static final DragonchessSet DRAGONCHESS_SET = new DragonchessSet();
	public static final PlayingCardSet PLAYING_CARD_SET = new PlayingCardSet();
	public static final ThreeDragonAnteSet THREE_DRAGON_ANTE_SET = new ThreeDragonAnteSet();
	public static final HerbalismKit HERBALISM_KIT = new HerbalismKit();
	public static final Bagpipes BAGPIPES = new Bagpipes();
	public static final Drum DRUM = new Drum();
	public static final Dulcimer DULCIMER = new Dulcimer();
	public static final Flute FLUTE = new Flute();
	public static final Lute LUTE = new Lute();
	public static final Lyre LYRE = new Lyre();
	public static final Horn HORN = new Horn();
	public static final PanFlute PAN_FLUTE = new PanFlute();
	public static final Shawm SHAWM = new Shawm();
	public static final Viol VIOL = new Viol();
	public static final NavigatorsTools NAVIGATORS_TOOLS = new NavigatorsTools();
	public static final PoisonersKit POISONERS_KIT = new PoisonersKit();
	public static final ThievesTools THIEVES_TOOLS = new ThievesTools();

	public static final List<Tool> toolList = asList(ALCHEMISTS_SUPPLIES, BREWERS_SUPPLIES, CALLIGRAPHERS_SUPPLIES,
			CARPENTERS_TOOLS, COBBLERS_TOOLS, COOKS_UTENSILS, GLASSBLOWERS_TOOLS, JEWELERS_TOOLS, LEATHERWORKERS_TOOLS,
			MASONS_TOOLS, PAINTERS_SUPPLIES, POTTERS_TOOLS, SMITHS_TOOLS, TINKERS_TOOLS, WEAVERS_TOOLS,
			WOODCARVERS_TOOLS, DISGUISE_KIT, FORGERY_KIT, DICE_SET, DRAGONCHESS_SET, PLAYING_CARD_SET,
			THREE_DRAGON_ANTE_SET, HERBALISM_KIT, BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE, HORN, PAN_FLUTE, SHAWM,
			VIOL, NAVIGATORS_TOOLS, POISONERS_KIT, THIEVES_TOOLS);
}
