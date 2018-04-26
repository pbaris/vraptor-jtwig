package br.com.caelum.vraptor.jtwig;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.nio.charset.StandardCharsets;

/**
 * @author Panos Bariamis (pbaris)
 */
@ApplicationScoped
public class JtwigRendererProducer {

	@Produces
	public JtwigRenderer getRenderer() {
		return new JtwigRenderer(getBuilder().build());
	}

	private EnvironmentConfigurationBuilder getBuilder() {
		return EnvironmentConfigurationBuilder
			.configuration()

			.render()
				.withOutputCharset(StandardCharsets.UTF_8)
			.and()

			.parser()
				.withoutTemplateCache()
			.and();
	}
}