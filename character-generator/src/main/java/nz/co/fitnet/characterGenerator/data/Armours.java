package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Breastplate;
import nz.co.fitnet.characterGenerator.data.equipment.armours.ChainMail;
import nz.co.fitnet.characterGenerator.data.equipment.armours.ChainShirt;
import nz.co.fitnet.characterGenerator.data.equipment.armours.HalfPlate;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Hide;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Leather;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Padded;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Plate;
import nz.co.fitnet.characterGenerator.data.equipment.armours.RingMail;
import nz.co.fitnet.characterGenerator.data.equipment.armours.ScaleMail;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Shield;
import nz.co.fitnet.characterGenerator.data.equipment.armours.Splint;
import nz.co.fitnet.characterGenerator.data.equipment.armours.StuddedLeather;

public class Armours {
	// light
	public static final Padded PADDED = new Padded();
	public static final Leather LEATHER = new Leather();
	public static final StuddedLeather STUDDED_LEATHER = new StuddedLeather();
	// medium
	public static final Hide HIDE = new Hide();
	public static final ChainShirt CHAIN_SHIRT = new ChainShirt();
	public static final ScaleMail SCALE_MAIL = new ScaleMail();
	public static final Breastplate BREASTPLATE = new Breastplate();
	public static final HalfPlate HALF_PLATE = new HalfPlate();
	// heavy
	public static final RingMail RING_MAIL = new RingMail();
	public static final ChainMail CHAIN_MAIL = new ChainMail();
	public static final Splint SPLINT = new Splint();
	public static final Plate PLATE = new Plate();
	// shield
	public static final Shield SHIELD = new Shield();

	public static final List<Armour> armourList = asList(PADDED, LEATHER, STUDDED_LEATHER, HIDE, CHAIN_SHIRT,
			SCALE_MAIL, BREASTPLATE, HALF_PLATE, RING_MAIL, CHAIN_MAIL, SPLINT, PLATE, SHIELD);
}
