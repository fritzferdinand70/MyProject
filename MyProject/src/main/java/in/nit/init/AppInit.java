package in.nit.init;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import in.nit.config.AppConfig2;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	//Provide Spring configuration file as input to web.xml(FC)
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class[] {AppConfig2.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
	//URL-pattern
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
