package com.myapp.config.web

import com.myapp.config.demo.DemoData
import org.apache.log4j.Logger
import org.springframework.context.annotation.Bean

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

import javax.sql.DataSource

@Configuration
@Profile('dev')
class WebDevConfig {

    final Logger log = Logger.getLogger(this.class)

    @Bean
    DataSource dataSource() {

        log.debug("loading dev datasource")

        BasicDataSource dataSource = new BasicDataSource()
        dataSource.driverClassName = 'org.hsqldb.jdbcDriver'
        dataSource.url = 'jdbc:hsqldb:mem:mart;hsqldb.applog=3;hsqldb.sqllog=0;hsqldb.tx=mvcc'
        dataSource.username = 'sa'
        dataSource.password = ''
        dataSource.maxTotal = 20

        dataSource.timeBetweenEvictionRunsMillis = 30000
        dataSource.removeAbandonedOnBorrow = true
        dataSource.logAbandoned = true
        dataSource.defaultAutoCommit = false
        dataSource.testOnBorrow = true
        dataSource.validationQuery = 'SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS'
        dataSource.maxWaitMillis = 3000


        return dataSource
    }

    @Bean
    DemoData demoData() {
        return new DemoData()
    }


    /*
    @Bean
    Properties hibernateProperties() {

        Properties properties = new Properties()

        properties['hibernate.dialect'] = 'org.hibernate.dialect.HSQLDialect'
        properties['hibernate.show_sql'] = false
        properties['hibernate.hbm2ddl.auto'] = 'create'
        properties['hibernate.cache.use_second_level_cache'] = false
        properties['hibernate.cache.use_query_cache'] = false
        //properties['hibernate.id.new_generator_mappings'] = false
        properties['hibernate.transaction.factory_class'] = 'org.hibernate.transaction.JDBCTransactionFactory'

        return properties
    }
    */



}
