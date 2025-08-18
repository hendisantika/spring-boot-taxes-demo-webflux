package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.helpers;

import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class WebExchangeHelper {
    public static String getFirstHeader(ServerRequest request, LogConstantHelper name) {
        return Optional.ofNullable(request)
                .map(ServerRequest::headers)
                .map(headers -> headers.firstHeader(name.getName()))
                .orElse(LogConstantHelper.EMPTY_STRING.getName());
    }
}
