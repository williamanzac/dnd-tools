package nz.co.fitnet.nameGenerator;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

	public static void main(final String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(final AppConfiguration configuration, final Environment environment) throws Exception {
		environment.jersey().register(new CustomBinder());
		environment.jersey().packages("nz.co.fitnet.nameGenerator.resources");
	}
}
