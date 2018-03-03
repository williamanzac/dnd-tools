package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class KnownLanguages {
	private final List<Language> languages = new ArrayList<>();
	private int additionalLanguages;

	public KnownLanguages(final Language... languages) {
		this(0, languages);
	}

	public KnownLanguages(final int additionalLanguages, final Language... languages) {
		this.additionalLanguages = additionalLanguages;
		this.languages.addAll(asList(languages));
	}

	public int getAdditionalLanguages() {
		return additionalLanguages;
	}

	public void setAdditionalLanguages(final int additionalLanguages) {
		this.additionalLanguages = additionalLanguages;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void addLanguage(final Language language) {
		languages.add(language);
	}
}
