package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class ProficiencyBuilder {
	private final RandomComparator<Tool> comparator;
	private final List<Tool> proficientTools = new ArrayList<>();
	private int numberToolProficiencies;

	@Inject
	public ProficiencyBuilder(final NumberService numberService) {
		comparator = new RandomComparator<>(numberService);
	}

	public ProficiencyBuilder withToolProficiencies(final List<Tool> tools) {
		proficientTools.addAll(tools);
		return this;
	}

	public ProficiencyBuilder withNumberToolProfifiencies(final int value) {
		numberToolProficiencies = value;
		return this;
	}

	public List<Tool> buildToolProficiencies() {
		final List<Tool> list = proficientTools.stream().sorted(comparator).limit(numberToolProficiencies)
				.collect(toList());
		return list;
	}
}
