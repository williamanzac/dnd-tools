package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Tool;

public class ToolProficiencies {
	private final List<Tool> proficientTools = new ArrayList<>(); // options?
	private int numberToolProficiencies;// options?

	public ToolProficiencies() {
	}

	public ToolProficiencies(final Tool... tools) {
		this(0, tools);
	}

	public ToolProficiencies(final int numberToolProficiencies, final Tool... tools) {
		proficientTools.addAll(asList(tools));
	}

	public List<Tool> getProficientTools() {
		return proficientTools;
	}

	public int getNumberToolProficiencies() {
		return numberToolProficiencies;
	}

	public void setNumberToolProficiencies(final int numberToolProficiencies) {
		this.numberToolProficiencies = numberToolProficiencies;
	}
}
