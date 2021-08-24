package com.example.CRMTorris.database.utils;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@EntityScan
@Configuration
@ImportResource({"classpath:hibernateConfiguration.xml"})
public class HibernateXMLConfiguration {
}
