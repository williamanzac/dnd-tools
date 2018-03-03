package nz.co.fitnet.client.controls.trait;

import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.client.CharacterBuilderModel;

public class AgeTraitPanel extends TraitPanel<AgeTrait> {

	public AgeTraitPanel(final AgeTrait trait, final CharacterBuilderModel model) {
		super(trait);
		final AgeTraitContentPanel contentPanel = new AgeTraitContentPanel(trait, model);
		setContent(contentPanel);
	}
}
