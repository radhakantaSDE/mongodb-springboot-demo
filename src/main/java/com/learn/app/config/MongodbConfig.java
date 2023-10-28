package com.learn.app.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.learn.app")
public class MongodbConfig extends AbstractMongoClientConfiguration {

  // It's always commanded to keep credentials in vault / external config manager
  private static final String DB_CONNECTION_STRING = "mongodb://app_user:app_password@localhost:37017/test_mongodb?authSource=admin";

  @Bean
  @Override
  public MongoClient mongoClient() {

    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder()
            .applyConnectionString(
                new ConnectionString(DB_CONNECTION_STRING))
            .build();
    return MongoClients.create(mongoClientSettings);
  }

  @Override
  protected String getDatabaseName() {
    return "test_mongodb";
  }

  @Override
  public Collection<String> getMappingBasePackages() {
    return Collections.singleton("com.learn.app");
  }
}
