package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.01
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    private final String database;
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String authenticationDatabase;
    private final boolean autoIndexCreation;


    public MongoConfig(@Value("${no-sql.mongo.database}") String database,
                       @Value("${no-sql.mongo.host}") String host,
                       @Value("${no-sql.mongo.port}") int port,
                       @Value("${no-sql.mongo.username}") String username,
                       @Value("${no-sql.mongo.password}") String password,
                       @Value("${no-sql.mongo.authentication-database}") String authenticationDatabase,
                       @Value("${no-sql.mongo.auto-index-creation}") boolean autoIndexCreation) {
        this.database = database;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.authenticationDatabase = authenticationDatabase;
        this.autoIndexCreation = autoIndexCreation;
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    protected boolean autoIndexCreation() {
        return this.autoIndexCreation;
    }

    @Bean
    @Override
    public MongoClient reactiveMongoClient() {
        // MongoDB server address
        ServerAddress serverAddress = new ServerAddress(this.host, this.port);
        // Authentication with `authenticationDatabase`
        MongoCredential credential = MongoCredential.createCredential(
                this.username, this.authenticationDatabase, this.password.toCharArray()
        );
        // MongoDB client configuration
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(List.of(serverAddress)))
                .credential(credential) // Configura autenticación
                .build();
        return MongoClients.create(settings);
    }

//    @Bean
//    @Primary
//    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
//        return new ReactiveMongoTemplate(new SimpleReactiveMongoDatabaseFactory(mongoClient, this.database));
//    }

    //remove '_class’ field
//    @Bean
//    @Primary
//    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
//        ReactiveMongoTemplate template = new ReactiveMongoTemplate(mongoClient, this.database);
//        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        converter.afterPropertiesSet();
//        System.out.println("MongoDB configurado sin campo _class");
//        return template;
//    }
}
