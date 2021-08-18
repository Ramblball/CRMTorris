package com.example.CRMTorris.database.utils;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan
@EnableJpaRepositories
@ImportResource({"classpath:hibernateConfiguration.xml"})
public class HibernateXMLConfiguration {

}
