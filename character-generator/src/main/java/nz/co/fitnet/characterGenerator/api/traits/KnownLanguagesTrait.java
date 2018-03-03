package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Languages;

import nz.co.fitnet.characterGenerator.api.KnownLanguages;
import nz.co.fitnet.characterGenerator.api.Language;

public class KnownLanguagesTrait extends Trait<KnownLanguages> {
	public KnownLanguagesTrait(final Language... languages) {
		this(0, languages);
	}

	public KnownLanguagesTrait(final int additionalLanguages, final Language... languages) {
		super(Languages, new KnownLanguages(additionalLanguages, languages));
	}
}
