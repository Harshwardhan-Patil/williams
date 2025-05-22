package com.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.AppConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class }; // Spring configuration class
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // No additional servlet context configuration
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Mapping of DispatcherServlet
    }
}
