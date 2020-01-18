package com.landq.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyFrontController extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("enters1");
		return new Class[]{MyConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("enters2");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("enters3");
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
