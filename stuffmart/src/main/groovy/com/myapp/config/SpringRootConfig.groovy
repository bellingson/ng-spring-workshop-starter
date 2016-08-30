package com.myapp.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

import java.text.SimpleDateFormat

@Configuration
@ComponentScan(basePackages = [ 'com.myapp.config.web', 'com.myapp.config.security', 'com.myapp.dao' ])
class SpringRootConfig {

    @Bean
    ObjectMapper jsonMapper() {
        ObjectMapper mapper = new ObjectMapper()
        mapper.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return mapper
    }



}
