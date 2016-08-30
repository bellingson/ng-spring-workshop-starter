package com.myapp.config.security

import com.myapp.config.security.UserRequestFilter
import com.myapp.filter.MySiteMeshFilter
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer

import javax.servlet.ServletContext

class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void afterSpringSecurityFilterChain(ServletContext servletContext) {

        servletContext.addFilter('user-reqest', new UserRequestFilter()).addMappingForUrlPatterns(null, false, '/*')

        servletContext.addFilter('site-mesh', new MySiteMeshFilter()).addMappingForUrlPatterns(null, false, '/*')

    }



}
