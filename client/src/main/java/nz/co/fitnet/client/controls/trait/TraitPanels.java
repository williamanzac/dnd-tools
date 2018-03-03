package nz.co.fitnet.client.controls.trait;

import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.Trait;
import nz.co.fitnet.client.CharacterBuilderModel;

public class TraitPanels {

	@SuppressWarnings("unchecked")
	public static <T extends Trait<?>> TraitPanel<T> panelFor(final T trait, final CharacterBuilderModel model) {
		if (trait instanceof AgeTrait) {
			return (TraitPanel<T>) new AgeTraitPanel((AgeTrait) trait, model);
		}
		return null;
	}
}
