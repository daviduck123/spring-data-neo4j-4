package com.example.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.example.repository")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {
	@Override
	@Bean
	public SessionFactory getSessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory("com.example.model", "BOOT-INF.classes.com.example.model");
	}

	// needed for session in view in web-applications
	@Override
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}
}