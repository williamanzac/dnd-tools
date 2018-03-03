package nz.co.fitnet.numberGenerator;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import nz.co.fitnet.numberGenerator.api.NumberService;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public final class CustomBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(NumberService.class).to(NumberGenerator.class);
	}
}