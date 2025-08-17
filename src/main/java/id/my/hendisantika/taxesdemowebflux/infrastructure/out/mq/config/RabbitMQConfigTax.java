package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config;

import id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config.ReactiveRabbitMQConfig;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

}
