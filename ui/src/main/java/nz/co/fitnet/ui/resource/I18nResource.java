package nz.co.fitnet.ui.resource;

import static java.util.Arrays.asList;
import static java.util.Locale.getAvailableLocales;
import static java.util.Locale.lookup;
import static java.util.Locale.LanguageRange.parse;
import static java.util.ResourceBundle.getBundle;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import java.util.Map;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

@Path("/i18n")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class I18nResource {

	@GET
	public Map<String, String> allForLanguage(final @HeaderParam("accept-language") String lang) {
		final Locale locale;
		if (StringUtils.isBlank(lang)) {
			locale = Locale.getDefault();
		} else {
			final List<LanguageRange> priorityList = parse(lang);
			final List<Locale> locales = asList(getAvailableLocales());
			locale = lookup(priorityList, locales);
		}
		final ResourceBundle bundle = getBundle("ui", locale);
		final Map<String, String> entries = new HashMap<>();
		for (final String key : bundle.keySet()) {
			entries.put(key.toLowerCase(), bundle.getString(key));
		}
		return entries;
	}
}
