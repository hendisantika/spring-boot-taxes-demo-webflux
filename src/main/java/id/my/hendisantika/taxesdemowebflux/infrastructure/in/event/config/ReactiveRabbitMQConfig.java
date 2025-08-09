package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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
}
