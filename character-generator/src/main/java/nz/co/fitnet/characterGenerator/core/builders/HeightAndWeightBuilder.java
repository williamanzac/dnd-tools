package nz.co.fitnet.characterGenerator.core.builders;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.core.DiceFormat;
import nz.co.fitnet.numberGenerator.api.NumberService;

@Service
public class HeightAndWeightBuilder {
	private Measurement height;
	private Measurement weight;
	private int heightMod;

	private final NumberService numberService;

	@Inject
	public HeightAndWeightBuilder(final NumberService numberService) {
		this.numberService = numberService;
	}

	public HeightAndWeightBuilder withHeight(final Measurement height) {
		this.height = height;
		return this;
	}

	public HeightAndWeightBuilder withWeight(final Measurement weight) {
		this.weight = weight;
		return this;
	}

	public int buildHeight() {
		final int baseHeight = height.getBase();
		final DiceFormat df = DiceFormat.parse(height.getModifier());
		if (df.getDie() == 0 || df.getTimes() == 0) {
			heightMod = (int) numberService.rollGaussianNumber(df.getModifier());
		} else {
			heightMod = df.getModifier();
			for (int i = 0; i < df.getTimes(); i++) {
				heightMod += (int) numberService.rollGaussianNumber(df.getDie());
			}
		}
		final int totalHeight = baseHeight + heightMod;
		return totalHeight;
	}

	public int buildWeight() {
		final int baseWeight = weight.getBase();
		int weightMod;
		final DiceFormat df = DiceFormat.parse(weight.getModifier());
		if (df.getDie() == 0 || df.getTimes() == 0) {
			weightMod = (int) numberService.rollGaussianNumber(df.getModifier());
		} else {
			weightMod = df.getModifier();
			for (int i = 0; i < df.getTimes(); i++) {
				weightMod += (int) numberService.rollGaussianNumber(df.getDie());
			}
		}
		final int totalWeight = baseWeight + heightMod * weightMod;
		return totalWeight;
	}
}
