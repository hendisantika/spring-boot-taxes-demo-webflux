package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config;

import com.rabbitmq.client.ConnectionFactory;
import id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config.model.RabbitMQConnectionProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.09
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class RabbitMQConnectionFactory {
    public static final String TLS_VERSION = "TLSv1.3";
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConnectionFactory.class.getName());
    private static final String FAIL_MSG = "Error creating ConnectionFactoryProvider ";

    @Bean
    //@Profile({ "local" })
    public ConnectionFactory getConnectionFactoryLocal(@Value("${rabbitmq.password}") final String pass,
                                                       @Value("${rabbitmq.port}") final Integer port,
                                                       @Value("${rabbitmq.username}") final String username,
                                                       @Value("${rabbitmq.host}") final String hostname,
                                                       @Value("${rabbitmq.virtual-host}") final String virtualHost) {
        var secret = new RabbitMQConnectionProperties();
        secret.setPort(port);
        secret.setUsername(username);
        secret.setPassword(pass);
        secret.setHostname(hostname);
        secret.setVirtualhost(virtualHost);
        return buildConnectionFactoryProvider(secret);
    }

    private ConnectionFactory buildConnectionFactoryProvider(RabbitMQConnectionProperties properties) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(properties.getHostname());
            factory.setPort(properties.getPort());
            factory.setUsername(properties.getUsername());
            factory.setPassword(properties.getPassword());
            factory.setVirtualHost(properties.getVirtualhost());
            return factory;
        } catch (Exception e) {
            LOGGER.error(FAIL_MSG, e);
            throw new RuntimeException(FAIL_MSG, e);
        }
    }
}
