package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.config;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

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


    @Bean(name = "baseWebClient")
    public WebClient getbaseWebClient(WebClient.Builder builder) {
        return builder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .clientConnector(getClientHttpConnector(HttpClient.create()))
                .build();
    }

    private ClientHttpConnector getClientHttpConnector(HttpClient client) {
        return new ReactorClientHttpConnector(client
                .compress(true)
                .keepAlive(true)
                .option(CONNECT_TIMEOUT_MILLIS, defaultConnectionTimeout)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(defaultReadTimeout, MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(defaultWriteTimeout, MILLISECONDS));
                }));
    }
}
