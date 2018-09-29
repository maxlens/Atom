package com.quark.atom.cassandra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(
  basePackages = "com.quark.atom.cassandra.repository")
public class AtomCassandraConfiguration extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpaceName;
	
	
	@Override
	protected String getKeyspaceName() {
		return keySpaceName;
	}

}
