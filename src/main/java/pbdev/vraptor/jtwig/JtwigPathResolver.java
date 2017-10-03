package pbdev.vraptor.jtwig;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

/**
 * @author Panos Bariamis (pbaris)
 */
@Specializes
public class JtwigPathResolver extends DefaultPathResolver {

	/**
	 * @deprecated CDI eyes only
	 */
	public JtwigPathResolver() {
		this(null);
	}

	@Inject
	public JtwigPathResolver(FormatResolver resolver) {
		super(resolver);
	}

	public String getPrefix() {
		return "";
	}

	public String getExtension() {
		return "twig";
	}
}