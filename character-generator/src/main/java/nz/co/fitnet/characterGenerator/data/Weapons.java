package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Battleaxe;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Blowgun;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Club;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Dagger;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Dart;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Flail;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Glaive;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Greataxe;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Greatclub;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Greatsword;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Halberd;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.HandCrossbow;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Handaxe;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.HeavyCrossbow;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Javelin;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Lance;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.LightCrossbow;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.LightHammer;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Longbow;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Longsword;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Mace;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Maul;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Morningstar;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Net;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Pike;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Quarterstaff;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Rapier;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Scimitar;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Shortbow;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Shortsword;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Sickle;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Sling;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Spear;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Trident;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.UnarmedStrike;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.WarPick;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Warhammer;
import nz.co.fitnet.characterGenerator.data.equipment.weapons.Whip;

public class Weapons {
	// Simple Melee Weapons
	public static final Club CLUB = new Club();
	public static final Dagger DAGGER = new Dagger();
	public static final Greatclub GREATCLUB = new Greatclub();
	public static final Handaxe HANDAXE = new Handaxe();
	public static final Javelin JAVELIN = new Javelin();
	public static final LightHammer LIGHT_HAMMER = new LightHammer();
	public static final Mace MACE = new Mace();
	public static final Quarterstaff QUARTERSTAFF = new Quarterstaff();
	public static final Sickle SICKLE = new Sickle();
	public static final Spear SPEAR = new Spear();
	public static final UnarmedStrike UNARMED_STRIKE = new UnarmedStrike();
	// Simple Ranged Weapons
	public static final LightCrossbow LIGHT_CROSSBOW = new LightCrossbow();
	public static final Dart DART = new Dart();
	public static final Shortbow SHORTBOW = new Shortbow();
	public static final Sling SLING = new Sling();
	// Martial Melee Weapons
	public static final Battleaxe BATTLEAXE = new Battleaxe();
	public static final Flail FLAIL = new Flail();
	public static final Glaive GLAIVE = new Glaive();
	public static final Greataxe GREATAXE = new Greataxe();
	public static final Greatsword GREATSWORD = new Greatsword();
	public static final Halberd HALBERD = new Halberd();
	public static final Lance LANCE = new Lance();
	public static final Longsword LONGSWORD = new Longsword();
	public static final Maul MAUL = new Maul();
	public static final Morningstar MORNINGSTAR = new Morningstar();
	public static final Pike PIKE = new Pike();
	public static final Rapier RAPIER = new Rapier();
	public static final Scimitar SCIMITAR = new Scimitar();
	public static final Shortsword SHORTSWORD = new Shortsword();
	public static final Trident TRIDENT = new Trident();
	public static final WarPick WAR_PICK = new WarPick();
	public static final Warhammer WARHAMMER = new Warhammer();
	public static final Whip WHIP = new Whip();
	// Martial Ranged Weapons
	public static final Blowgun BLOWGUN = new Blowgun();
	public static final HandCrossbow HAND_CROSSBOW = new HandCrossbow();
	public static final HeavyCrossbow HEAVY_CROSSBOW = new HeavyCrossbow();
	public static final Longbow LONGBOW = new Longbow();
	public static final Net NET = new Net();

	public static final List<Weapon> weaponList = asList(CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE,
			QUARTERSTAFF, SICKLE, SPEAR, UNARMED_STRIKE, LIGHT_CROSSBOW, DART, SHORTBOW, SLING, BATTLEAXE, FLAIL,
			GLAIVE, GREATAXE, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT,
			WAR_PICK, WARHAMMER, WHIP, BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET);
}
