package br.com.caelum.vraptor.jtwig;

import org.jtwig.web.servlet.JtwigRenderer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Panos Bariamis (pbaris)
 */
public class JtwigServlet extends HttpServlet {

	private final JtwigRenderer renderer;

	/**
	 * @deprecated CDI eyes only
	 */
	public JtwigServlet() {
		this(null);
	}

	@Inject
	public JtwigServlet(JtwigRenderer renderer) {
		this.renderer = renderer;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		renderer.dispatcherFor(getPath(request)).render(request, response);
	}

	private static String getPath(HttpServletRequest request) {
		String path = (String)request.getAttribute("javax.servlet.include.servlet_path");
		String info = (String)request.getAttribute("javax.servlet.include.path_info");
		if (path == null) {
			path = request.getServletPath();
			info = request.getPathInfo();
		}
		if (info != null) {
			path += info;
		}
		return path;
	}
}