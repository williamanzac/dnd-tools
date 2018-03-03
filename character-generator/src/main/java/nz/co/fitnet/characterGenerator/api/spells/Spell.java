package nz.co.fitnet.characterGenerator.api.spells;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Spell {
	protected School school;
	protected int level;
	protected String castingTime;
	protected String range;
	protected Set<Component> components;
	protected String duration;
	protected final List<String> classes = new ArrayList<>();

	public School getSchool() {
		return school;
	}

	public int getLevel() {
		return level;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public String getRange() {
		return range;
	}

	public Set<Component> getComponents() {
		return components;
	}

	public String getDuration() {
		return duration;
	}

	public List<String> getClasses() {
		return classes;
	}
}
