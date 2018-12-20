package com.example.src.Filter.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public abstract class AbstractMongoConfig {

	protected String host;
	protected int port;
	protected String username;
	protected String password;
	protected String database;

	@SuppressWarnings("deprecation")
	public MongoDbFactory mongoDbFactory() {
		ServerAddress serverAddress = new ServerAddress(host, port);
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		credentialsList.add(MongoCredential.createCredential(username, database, password.toCharArray()));
		return new SimpleMongoDbFactory(new MongoClient(serverAddress,credentialsList), database);
	}
	
	abstract public MongoTemplate getMongoTemplate() throws Exception;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}
