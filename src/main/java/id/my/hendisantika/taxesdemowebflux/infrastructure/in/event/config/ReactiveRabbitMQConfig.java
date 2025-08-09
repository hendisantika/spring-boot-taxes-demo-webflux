package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config;

import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.scheduler.Schedulers;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.27
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class ReactiveRabbitMQConfig {
    public static final String TLS_VERSION = "TLSv1.3";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveRabbitMQConfig.class.getName());
    private static final String FAIL_MSG = "Error creating ConnectionFactoryProvider ";

    @Bean
    public String rabbitQueueName(@Value("${rabbitmq.queue-name}") final String queueName) {
        return queueName;
    }

    @Bean
    @Order(3)
    public Receiver receiver(@Value("${rabbitmq.password}") final String pass,
                             @Value("${rabbitmq.port}") final Integer port,
                             @Value("${rabbitmq.username}") final String username,
                             @Value("${rabbitmq.host}") final String hostname,
                             @Value("${rabbitmq.virtual-host}") final String virtualHost) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(hostname);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(pass);
        connectionFactory.setPort(port);
        connectionFactory.setVirtualHost(virtualHost);
        //this.configureSsl(connectionFactory);

        ReceiverOptions receiverOptions = new ReceiverOptions()
                .connectionFactory(connectionFactory)
                .connectionSubscriptionScheduler(Schedulers.boundedElastic());

        return RabbitFlux.createReceiver(receiverOptions);
    }
//    private void configureSsl(ConnectionFactory factory) {
//        try {
//            var sslContext = SSLContext.getInstance(TLS_VERSION);
//            sslContext.init(null, new TrustManager[] {new TrustEverythingTrustManager()}, null);
//            factory.useSslProtocol(sslContext);
//        } catch (NoSuchAlgorithmException | KeyManagementException e) {
//            LOGGER.error(FAIL_MSG, e);
//        }
//    }

    @Bean
    public ApplicationRunner rabbitQueueInitializer(RabbitAdmin rabbitAdmin) {
        return args -> {
            LOGGER.info("📌 Creating RabbitMQ queues before starting the application...");
            rabbitAdmin.initialize(); // Ensures that queues and bindings are created before other beans are executed
            LOGGER.info("✅ Colas de RabbitMQ creadas.");
        };
    }
}
