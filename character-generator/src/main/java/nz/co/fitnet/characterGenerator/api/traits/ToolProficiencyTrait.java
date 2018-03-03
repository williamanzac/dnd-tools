package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.ToolProficiency;

import nz.co.fitnet.characterGenerator.api.ToolProficiencies;
import nz.co.fitnet.characterGenerator.api.equipment.Tool;

public abstract class ToolProficiencyTrait extends Trait<ToolProficiencies> {
	public ToolProficiencyTrait(final Tool... tools) {
		this(0, tools);
	}

	public ToolProficiencyTrait(final int number, final Tool... tools) {
		super(ToolProficiency, new ToolProficiencies(number, tools));
	}
}
