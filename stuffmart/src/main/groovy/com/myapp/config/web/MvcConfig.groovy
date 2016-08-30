package com.myapp.config.web

import org.apache.log4j.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

@EnableWebMvc
@ComponentScan(basePackages = [ 'com.myapp.controllers' ])
class MvcConfig extends WebMvcConfigurerAdapter {

    final Logger log = Logger.getLogger(this.class)

    MvcConfig() {
        log.debug("initializing MvcConfig")
    }

    @Bean
    InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver()
        viewResolver.prefix = '/WEB-INF/jsp/'
        viewResolver.suffix = '.jsp'
        return viewResolver
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/admin/pmgr/**").addResourceLocations("/admin/pmgr/")
        registry.addResourceHandler("/style/**").addResourceLocations("/style/")
        registry.addResourceHandler("/script/**").addResourceLocations("/script/")
        registry.addResourceHandler("/image/**").addResourceLocations("/image/")
        registry.addResourceHandler("/admin/product/app/**").addResourceLocations("/admin/product/app/")
    }



}
