package nz.co.fitnet.ui;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class App extends Application<AppConfiguration> {

	public static void main(final String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
		super.initialize(bootstrap);
		bootstrap.addBundle(new AssetsBundle("/js", "/js", null, "js"));
		bootstrap.addBundle(new AssetsBundle("/css", "/css", null, "css"));
		// bootstrap.addBundle(new AssetsBundle("/ui", "/ui", "index.html"));
		bootstrap.addBundle(new ViewBundle<AppConfiguration>());
	}

	@Override
	public void run(final AppConfiguration configuration, final Environment environment) throws Exception {
		environment.jersey().register(new CustomBinder());
		environment.jersey().packages("nz.co.fitnet.ui.resource");
	}
}
