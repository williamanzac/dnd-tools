package nz.co.fitnet.characterGenerator.api;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.features.Feature;

public class Archetype {
	protected final List<Feature> features = new ArrayList<>();

	public List<Feature> getFeatures() {
		return features;
	}
}
