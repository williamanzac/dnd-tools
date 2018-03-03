package nz.co.fitnet.nameGenerator.data.names.definitions;

import static nz.co.fitnet.nameGenerator.api.Gender.Female;
import static nz.co.fitnet.nameGenerator.api.Gender.Male;

import nz.co.fitnet.nameGenerator.api.NameDefinition;
import nz.co.fitnet.nameGenerator.api.NamePartDefinition;

public class CalishiteNames extends NameDefinition {
	private static final NamePartDefinition MALE_DEFINITION = new NamePartDefinition(Male.name(), "Aseir", "Bardeid",
			"Haseid", "Khemed", "Mehmen", "Sudeiman", "Zasheir");
	private static final NamePartDefinition FEMALE_DEFINITON = new NamePartDefinition(Female.name(), "Atala", "Ceidil",
			"Hama", "Jasmal", "Meilil", "Seipora", "Yasheira", "Zasheida");
	private static final NamePartDefinition SURNAME_DEFINITION = new NamePartDefinition("surname", "Basha", "Dumein",
			"Jassan", "Khalid", "Mostana", "Pashar", "Rein");

	public CalishiteNames() {
		format = "{gender} surname";
		nameParts.add(MALE_DEFINITION);
		nameParts.add(FEMALE_DEFINITON);
		nameParts.add(SURNAME_DEFINITION);
	}
}
