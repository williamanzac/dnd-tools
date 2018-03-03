package nz.co.fitnet.characterGenerator.core.builders;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.StartingWealth;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class StartingWealthBuilder {
	private StartingWealth startingWealth;

	private final NumberGenerator numberService;

	@Inject
	public StartingWealthBuilder(final NumberGenerator numberService) {
		this.numberService = numberService;
	}

	public StartingWealthBuilder withStartingWealth(final StartingWealth startingWealth) {
		this.startingWealth = startingWealth;
		return this;
	}

	public Money build() {
		final Money money = new Money();
		final int numDice = startingWealth.getNumDice();
		final int dice = startingWealth.getDiceSides();
		int amount = numberService.rollDice(dice, numDice).stream().reduce((t, n) -> t + n).get();
		final int times = startingWealth.getMultiplier();
		amount *= times;
		final String coinType = "gp";
		switch (coinType) {
		case "pp":
			money.setPlatinum(amount);
			break;
		case "gp":
			money.setGold(amount);
			break;
		case "ep":
			money.setElectrum(amount);
			break;
		case "sp":
			money.setSilver(amount);
			break;
		case "cp":
			money.setCopper(amount);
			break;
		}
		return money;
	}
}
