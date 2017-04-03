package pl.ndt.manager;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Registers configuration classes in Spring Context
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Registers configuration classes in Spring Context
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	/**
	 * Specifies web mapping
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
