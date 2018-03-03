package nz.co.fitnet.characterGenerator.core.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class LanguageBuilder {
	private static final RandomCompator<Language> COMPARATOR = new RandomCompator<>();

	private final List<Language> knownLanguages = new ArrayList<>();
	private final List<Language> languages = new ArrayList<>();
	private int additionalLanguages;

	public LanguageBuilder withKnownLanguages(final List<Language> languages) {
		knownLanguages.addAll(languages);
		return this;
	}

	public LanguageBuilder withLanguages(final List<Language> languages) {
		this.languages.addAll(languages);
		return this;
	}

	public LanguageBuilder withLanguage(final Language language) {
		languages.add(language);
		return this;
	}

	public LanguageBuilder withAdditionalLanguages(final int value) {
		additionalLanguages = value;
		return this;
	}

	public List<Language> build() {
		if (languages.size() < additionalLanguages) {
			final List<Language> list = Stream.of(Language.values())
					.filter(l -> !languages.contains(l) && !knownLanguages.contains(l)).sorted(COMPARATOR)
					.limit(additionalLanguages - languages.size()).collect(Collectors.toList());
			languages.addAll(list);
		}
		return languages;
	}

	void setNumberService(final NumberService numberService) {
		COMPARATOR.setNumberService(numberService);
	}
}
