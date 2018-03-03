package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.races.Dragonborn;
import nz.co.fitnet.characterGenerator.data.races.Drow;
import nz.co.fitnet.characterGenerator.data.races.ForestGnome;
import nz.co.fitnet.characterGenerator.data.races.HalfElf;
import nz.co.fitnet.characterGenerator.data.races.HalfOrc;
import nz.co.fitnet.characterGenerator.data.races.HighElf;
import nz.co.fitnet.characterGenerator.data.races.HillDwarf;
import nz.co.fitnet.characterGenerator.data.races.Human;
import nz.co.fitnet.characterGenerator.data.races.Lightfoot;
import nz.co.fitnet.characterGenerator.data.races.MountainDwarf;
import nz.co.fitnet.characterGenerator.data.races.RockGnome;
import nz.co.fitnet.characterGenerator.data.races.Stout;
import nz.co.fitnet.characterGenerator.data.races.Tiefling;
import nz.co.fitnet.characterGenerator.data.races.WoodElf;

public class Races {
	public static final Dragonborn DRAGONBORN = new Dragonborn();
	public static final Drow DROW = new Drow();
	public static final ForestGnome FOREST_GNOME = new ForestGnome();
	public static final HalfElf HALF_ELF = new HalfElf();
	public static final HalfOrc HALF_ORC = new HalfOrc();
	public static final HighElf HIGH_ELF = new HighElf();
	public static final HillDwarf HILL_DWARF = new HillDwarf();
	public static final Human HUMAN = new Human();
	public static final Lightfoot LIGHTFOOT = new Lightfoot();
	public static final MountainDwarf MOUNTAIN_DWARF = new MountainDwarf();
	public static final RockGnome ROCK_GNOME = new RockGnome();
	public static final Stout STOUT = new Stout();
	public static final Tiefling TIEFLING = new Tiefling();
	public static final WoodElf WOOD_ELF = new WoodElf();

	public static final List<Race> raceList = asList(DRAGONBORN, DROW, FOREST_GNOME, HALF_ELF, HALF_ORC, HIGH_ELF,
			HILL_DWARF, HUMAN, LIGHTFOOT, MOUNTAIN_DWARF, ROCK_GNOME, STOUT, TIEFLING, WOOD_ELF);
}
