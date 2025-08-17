package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config;

import id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config.ReactiveRabbitMQConfig;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.07
 * To change this template use File | Settings | File Templates.
 */
@Primary
@Configuration
public class RabbitMQConfigTax {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReactiveRabbitMQConfig.class.getName());

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Primary
    public Queue queue(@Value("${rabbitmq.queue-name}") final String queueName) {
        LOGGER.info("\uD83D\uDCCC Creando cola de RabbitMQ antes de iniciar la aplicación...{}", queueName);
        return new Queue(queueName, true);
    }
}
