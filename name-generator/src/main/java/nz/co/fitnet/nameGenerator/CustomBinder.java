package nz.co.fitnet.nameGenerator;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import nz.co.fitnet.nameGenerator.api.NameService;
import nz.co.fitnet.nameGenerator.core.NameGenerator;

public final class CustomBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(NameService.class).to(NameGenerator.class);
	}
}