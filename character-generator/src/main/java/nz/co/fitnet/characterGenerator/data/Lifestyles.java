package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Lifestyle;
import nz.co.fitnet.characterGenerator.data.equipment.Aristocratic;
import nz.co.fitnet.characterGenerator.data.equipment.Comfortable;
import nz.co.fitnet.characterGenerator.data.equipment.Modest;
import nz.co.fitnet.characterGenerator.data.equipment.Poor;
import nz.co.fitnet.characterGenerator.data.equipment.Squalid;
import nz.co.fitnet.characterGenerator.data.equipment.Wealthy;
import nz.co.fitnet.characterGenerator.data.equipment.Wretched;

public class Lifestyles {
	public static final Wretched WRETCHED = new Wretched();
	public static final Squalid SQUALID = new Squalid();
	public static final Poor POOR = new Poor();
	public static final Modest MODEST = new Modest();
	public static final Comfortable COMFORTABLE = new Comfortable();
	public static final Wealthy WEALTHY = new Wealthy();
	public static final Aristocratic ARISTOCRATIC = new Aristocratic();

	public static final List<Lifestyle> lifestyleList = asList(WRETCHED, SQUALID, POOR, MODEST, COMFORTABLE, WEALTHY,
			ARISTOCRATIC);
}
