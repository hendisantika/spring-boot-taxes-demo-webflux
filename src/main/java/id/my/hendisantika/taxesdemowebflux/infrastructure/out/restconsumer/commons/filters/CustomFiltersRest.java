package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.filters;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.12
 * To change this template use File | Settings | File Templates.
 */
public class CustomFiltersRest {
    private static final Logger LOGGER = Logger.getLogger(CustomFiltersRest.class.getName());

    public static ExchangeFilterFunction loggingFilter() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            LOGGER.info("➡️ Request: " + clientRequest.method() + " " + clientRequest.url());
            LOGGER.info("➡️ Request Headers: " + clientRequest.headers());
            return Mono.just(clientRequest);
        }).andThen(ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            LOGGER.info("⬅️ Response: " + clientResponse.statusCode());
            return Mono.just(clientResponse);
        }));
    }
}
