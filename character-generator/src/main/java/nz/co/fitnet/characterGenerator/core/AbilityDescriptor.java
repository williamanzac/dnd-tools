package nz.co.fitnet.characterGenerator.core;

import nz.co.fitnet.characterGenerator.api.Ability;

public class AbilityDescriptor {
	public static String describe(final Ability ability) {
		switch (ability) {
		case STR:
			return Messages.getString("AbilityDescriptor.0"); //$NON-NLS-1$

		default:
			return null;
		}
	}
}
