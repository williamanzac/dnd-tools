package nz.co.fitnet.nameGenerator.data.names.definitions;

import static nz.co.fitnet.nameGenerator.api.Gender.Female;
import static nz.co.fitnet.nameGenerator.api.Gender.Male;

import nz.co.fitnet.nameGenerator.api.NameDefinition;
import nz.co.fitnet.nameGenerator.api.NamePartDefinition;

public class DwarfNames extends NameDefinition {
	private static final NamePartDefinition CLAN_DEFINITION = new NamePartDefinition("clan", "Balderk", "Battlehammer",
			"Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr",
			"Rumnaheim", "Strakeln", "Torunn", "Ungart");
	private static final NamePartDefinition FEMALE_DEFINITION = new NamePartDefinition(Female.name(), "Amber", "Artin",
			"Audhild", "Bardryn", "Dagnal", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda", "Gurdis", "Helja",
			"Hlin", "Kathra", "Kristryd", "Ilde", "Liftrasa", "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga",
			"Vistra");
	private static final NamePartDefinition MALE_DEFINITION = new NamePartDefinition(Male.name(), "Adrik", "Alberich",
			"Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint",
			"Gardain", "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin",
			"Thorin", "Tordek", "Traubon", "Travok", "Ulfgar", "Veit", "Vondal");

	public DwarfNames() {
		format = "{gender} clan";
		nameParts.add(MALE_DEFINITION);
		nameParts.add(FEMALE_DEFINITION);
		nameParts.add(CLAN_DEFINITION);
	}
}
