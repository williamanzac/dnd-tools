package nz.co.fitnet.characterGenerator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class DiceFormat {

	private static final Pattern PATTERN = Pattern.compile("(\\d+)d(\\d+)([\\+-]?\\d+)?|([\\+-]?\\d+)");

	private final int times;
	private final int die;
	private final int modifier;

	private DiceFormat(final int times, final int die, final int modifier) {
		this.die = die;
		this.modifier = modifier;
		this.times = times;
	}

	public static DiceFormat parse(final String value) {
		final Matcher matcher = PATTERN.matcher(value);
		int times = 0;
		int modifier = 0;
		int die = 0;
		if (matcher.matches()) {
			if (StringUtils.isNotBlank(matcher.group(4))) {
				modifier = Integer.valueOf(matcher.group(1));
			} else {
				times = Integer.valueOf(matcher.group(1));
				die = Integer.valueOf(matcher.group(2));
				if (StringUtils.isNotBlank(matcher.group(3))) {
					modifier = Integer.valueOf(matcher.group(3));
				}
			}
		}
		return new DiceFormat(times, die, modifier);
	}

	public int getTimes() {
		return times;
	}

	public int getDie() {
		return die;
	}

	public int getModifier() {
		return modifier;
	}
}
