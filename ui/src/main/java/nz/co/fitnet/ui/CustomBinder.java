package nz.co.fitnet.ui;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import nz.co.fitnet.nameGenerator.core.NameGenerator;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public final class CustomBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(NumberGenerator.class).to(NumberGenerator.class);
		bind(NameGenerator.class).to(NameGenerator.class);
	}
}