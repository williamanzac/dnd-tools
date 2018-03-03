package nz.co.fitnet.characterGenerator.data.features;

import static nz.co.fitnet.characterGenerator.api.Ability.DEX;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.features.Feature;

public class DangerSense extends Feature {
	private final List<Ability> savingThrowAdvantages = new ArrayList<>();

	public DangerSense() {
		super(2);
		savingThrowAdvantages.add(DEX);
	}

	public List<Ability> getSavingThrowAdvantages() {
		return savingThrowAdvantages;
	}
}
