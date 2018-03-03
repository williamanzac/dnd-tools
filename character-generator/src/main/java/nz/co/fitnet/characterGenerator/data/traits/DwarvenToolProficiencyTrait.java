package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.data.Tools.BREWERS_SUPPLIES;
import static nz.co.fitnet.characterGenerator.data.Tools.MASONS_TOOLS;
import static nz.co.fitnet.characterGenerator.data.Tools.SMITHS_TOOLS;

import nz.co.fitnet.characterGenerator.api.traits.ToolProficiencyTrait;

public class DwarvenToolProficiencyTrait extends ToolProficiencyTrait {
	public DwarvenToolProficiencyTrait() {
		super(1, SMITHS_TOOLS, BREWERS_SUPPLIES, MASONS_TOOLS);
	}
}
