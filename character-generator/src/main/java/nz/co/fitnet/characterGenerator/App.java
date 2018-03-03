package nz.co.fitnet.characterGenerator;

import javax.ws.rs.client.Client;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

	public static void main(final String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(final AppConfiguration configuration, final Environment environment) throws Exception {
		final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
				.build(getName());

		environment.jersey().register(new CustomBinder(client));
		environment.jersey().packages("nz.co.fitnet.characterGenerator.resources");
	}
}
