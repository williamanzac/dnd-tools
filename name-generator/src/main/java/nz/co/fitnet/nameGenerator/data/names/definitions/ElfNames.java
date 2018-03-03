package nz.co.fitnet.nameGenerator.data.names.definitions;

import static nz.co.fitnet.nameGenerator.api.Gender.Female;
import static nz.co.fitnet.nameGenerator.api.Gender.Male;
import static nz.co.fitnet.nameGenerator.api.Type.Random;

import nz.co.fitnet.nameGenerator.api.NameDefinition;
import nz.co.fitnet.nameGenerator.api.NamePartDefinition;

public class ElfNames extends NameDefinition {
	private static final NamePartDefinition MALE_DEFINITION = new NamePartDefinition(Male.name(), "Adran", "Aelar",
			"Aramil", "Arannis", "Aust", "Beiro", "Berrian", "Carric", "Enialis", "Erdan", "Erevan", "Galinndan",
			"Hadarai", "Heian", "Himo", "Immeral", "Ivellios", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion",
			"Riardon", "Rolenn", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis");
	private static final NamePartDefinition FEMALE_DEFINITON = new NamePartDefinition(Female.name(), "Adrie", "Althaea",
			"Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial",
			"Ielenia", "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna",
			"Quillathe", "Sariel", "Shanairra", "Shava", "Silaqui", "Theirastra", "Thia", "Vadania", "Valanthe",
			"Xanaphia");
	private static final NamePartDefinition FAMILY_DEFINITION = new NamePartDefinition(Random, "family",
			"Amakiir (Gemflower)", "Amastacia (Starflower)", "Galanodel (Moonwhisper)", "Holimion (Diamonddew)",
			"Ilphelkiir (Gemblossom)", "Liadon (Silverfrond)", "Meliamne (Oakenheel)", "Nai'lo (Nightbreeze)",
			"Siannodel (Moonbrook)", "Xiloscient (Goldpetal)");

	public ElfNames() {
		format = "{gender} family";
		nameParts.add(MALE_DEFINITION);
		nameParts.add(FEMALE_DEFINITON);
		nameParts.add(FAMILY_DEFINITION);
	}
}
