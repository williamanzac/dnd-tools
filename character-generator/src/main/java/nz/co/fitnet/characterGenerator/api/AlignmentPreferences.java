package nz.co.fitnet.characterGenerator.api;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class AlignmentPreferences {
	private final List<Alignment> alignments = new ArrayList<>();

	public AlignmentPreferences() {
	}

	public AlignmentPreferences(final Alignment... alignments) {
		this.alignments.addAll(asList(alignments));
	}

	public List<Alignment> getAlignments() {
		return alignments;
	}
}
