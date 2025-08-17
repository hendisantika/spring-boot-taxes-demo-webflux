package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.25
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RestConsumerConfig {

    private final int defaultConnectionTimeout;
    private final int defaultReadTimeout;
    private final int defaultWriteTimeout;

    public RestConsumerConfig(@Value("${rest-consumer.timeout.default-connection}") int connectionTimeout,
                              @Value("${rest-consumer.timeout.default-read}") int defaultReadTimeout,
                              @Value("${rest-consumer.timeout.default-write}") int defaultWriteTimeout) {
        this.defaultConnectionTimeout = connectionTimeout;
        this.defaultReadTimeout = defaultReadTimeout;
        this.defaultWriteTimeout = defaultWriteTimeout;
    }
}
