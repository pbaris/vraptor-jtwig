## vraptor-jtwig
[Jtwig](http://jtwig.org/) template engine plugin for Vraptor 4 

### Use
Just add your templates in `WEB-INF/jtwig` with extension `.jtwig`

By default there is an environment configuration with the setup
```java
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
```

You can provide your own environment configuration, by creating an alternative for this producer.
