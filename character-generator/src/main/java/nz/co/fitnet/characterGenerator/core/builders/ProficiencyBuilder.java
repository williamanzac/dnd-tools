package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class ProficiencyBuilder {
	private static final RandomCompator<Tool> COMPARATOR = new RandomCompator<>();
	private final List<Tool> proficientTools = new ArrayList<>();
	private int numberToolProficiencies;

	public ProficiencyBuilder withToolProficiencies(final List<Tool> tools) {
		proficientTools.addAll(tools);
		return this;
	}

	public ProficiencyBuilder withNumberToolProfifiencies(final int value) {
		numberToolProficiencies = value;
		return this;
	}

	public List<Tool> buildToolProficiencies() {
		final List<Tool> list = proficientTools.stream().sorted(COMPARATOR).limit(numberToolProficiencies)
				.collect(toList());
		return list;
	}

	void setNumberService(final NumberService numberService) {
		COMPARATOR.setNumberService(numberService);
	}
}
