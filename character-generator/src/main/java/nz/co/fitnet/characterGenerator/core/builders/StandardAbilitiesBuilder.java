package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class StandardAbilitiesBuilder extends AbstractAbilitiesBuilder implements AbilitiesBuilder {

	public static final List<Integer> STANDARD_ARRAY = asList(15, 14, 13, 12, 10, 8);
	private final List<Integer> stats = new ArrayList<>(STANDARD_ARRAY);

	@Inject
	public StandardAbilitiesBuilder(final NumberService numberService) {
		super(numberService);
	}

	@Override
	protected List<Integer> statList(final List<Ability> abilityList) {
		return abilityList.stream().map((ability) -> generateScore()).sorted((a, b) -> b - a).collect(toList());
	}

	private int generateScore() {
		return stats.remove(0);
	}
}
