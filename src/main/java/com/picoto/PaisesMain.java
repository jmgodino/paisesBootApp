package com.picoto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
@EnableWebMvc
@EnableMongoRepositories
public class PaisesMain extends AbstractMongoConfiguration {
	
	@Value("${mongodb.url}")
	private String mongoURL;
	
	@Value("${mongodb.database}")
	private String mongoDatabase;

	public static void main(String[] args) {
		SpringApplication.run(PaisesMain.class, args);
	}

	@Override
	public String getDatabaseName() {
		return mongoDatabase;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoURL);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	    PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
	    ppc.setLocation(new ClassPathResource("application.properties"));
	    return ppc;
	}
	
}
