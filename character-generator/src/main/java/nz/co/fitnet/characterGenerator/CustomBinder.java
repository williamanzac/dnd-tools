package nz.co.fitnet.characterGenerator;

import javax.ws.rs.client.Client;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import nz.co.fitnet.characterGenerator.core.NumberGenerator;

public final class CustomBinder extends AbstractBinder {

	private final Client client;

	public CustomBinder(final Client client) {
		this.client = client;
	}

	@Override
	protected void configure() {
		bind(NumberGenerator.class).to(NumberGenerator.class);
		bind(client).to(Client.class);
	}
}