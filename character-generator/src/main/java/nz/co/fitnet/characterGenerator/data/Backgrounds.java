package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.Background;
import nz.co.fitnet.characterGenerator.data.backgrounds.Acolyte;
import nz.co.fitnet.characterGenerator.data.backgrounds.Charlatan;

public class Backgrounds {
	public static final Acolyte ACOLYTE = new Acolyte();
	public static final Charlatan CHARLATAN = new Charlatan();

	public static final List<Background> backgroundList = asList(ACOLYTE, CHARLATAN);
}
