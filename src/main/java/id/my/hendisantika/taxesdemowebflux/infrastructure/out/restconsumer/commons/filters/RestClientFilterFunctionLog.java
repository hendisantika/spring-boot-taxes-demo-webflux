package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.filters;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.13
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class RestClientFilterFunctionLog implements ExchangeFilterFunction {

    private static final Logger logger = Logger.getLogger(RestClientFilterFunctionLog.class.getName());
    private final String componentName;

}
