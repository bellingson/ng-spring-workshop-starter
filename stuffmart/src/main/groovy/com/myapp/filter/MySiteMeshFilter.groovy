package com.myapp.filter

import org.sitemesh.builder.SiteMeshFilterBuilder
import org.sitemesh.config.ConfigurableSiteMeshFilter

class MySiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/jsp/decorator.jsp")
        builder.addExcludedPath("*.html")
    }

}
