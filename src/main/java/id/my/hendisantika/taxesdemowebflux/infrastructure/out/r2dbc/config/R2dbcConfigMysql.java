package id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import dev.miku.r2dbc.mysql.constant.SslMode;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.15
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableTransactionManagement
@EnableR2dbcRepositories(basePackages = "id.my.hendisantika.taxesdemowebflux.infrastructure")
public class R2dbcConfigMysql {
    public ConnectionFactory connectionFactory(@Value("${r2dbc.mysql.url}") String url,
                                               @Value("${r2dbc.mysql.username}") String username,
                                               @Value("${r2dbc.mysql.password}") String password) {
        //"r2dbc:mysql://localhost:3306/your_database"
        return ConnectionFactoryBuilder.withUrl(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public ConnectionFactory connectionFactoryPool(@Value("${r2dbc.mysql.host}") String host,
                                                   @Value("${r2dbc.mysql.port}") Integer port,
                                                   @Value("${r2dbc.mysql.username}") String username,
                                                   @Value("${r2dbc.mysql.password}") String password,
                                                   @Value("${r2dbc.mysql.database}") String database
    ) {
        MySqlConnectionFactory mysqlFactory = MySqlConnectionFactory.from(
                MySqlConnectionConfiguration.builder()
                        .host(host)
                        .port(port)
                        .username(username)
                        .password(password)
                        .database(database)
                        .sslMode(SslMode.DISABLED)
                        .build()
        );
        ConnectionPoolConfiguration poolConfig = ConnectionPoolConfiguration.builder(mysqlFactory)
                .initialSize(5)  // Initial connections in the pool
                .maxSize(20)     // Maximum connections in the pool
                .maxIdleTime(Duration.ofMinutes(30)) // Maximum downtime
                .validationQuery("SELECT 1") // Connection validation
                .build();
        return new ConnectionPool(poolConfig);
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }
}
