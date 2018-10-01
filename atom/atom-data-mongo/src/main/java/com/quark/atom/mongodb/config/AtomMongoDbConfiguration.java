package com.quark.atom.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages= {"com.quark.atom.mongodb.repository"})
public class AtomMongoDbConfiguration extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.host}")
	private String host;
	
	@Value("${spring.data.mongodb.port}")
	private int port;
	
	@Value("${spring.data.mongodb.database}")
	private String database;

	@Override
	public MongoClient mongoClient() {
		return  new MongoClient(host, port);
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

}
