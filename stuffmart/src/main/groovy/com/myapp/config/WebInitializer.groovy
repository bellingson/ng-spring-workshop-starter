package com.myapp.config

import com.myapp.config.security.SecurityConfig
import com.myapp.config.web.MvcConfig
import org.apache.log4j.Logger
import org.apache.log4j.xml.DOMConfigurator
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

import javax.servlet.ServletContext

class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    final Logger log = Logger.getLogger(this.class)

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return [SpringRootConfig.class, SecurityConfig.class ]
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return [MvcConfig.class ]
    }

    @Override
    protected String[] getServletMappings() {
        return [ '/' ]
    }

    @Override
    public void onStartup(ServletContext container) {


        URL log4j = this.class.getClassLoader().getResource("log4j.xml")

        println("ON STARTUP: ${log4j}")

        DOMConfigurator.configure(log4j)


        log.debug('on startup: start')

        System.setProperty('spring.profiles.active','dev')

        super.onStartup(container)
        log.debug('on startup: complete')
    }


}


