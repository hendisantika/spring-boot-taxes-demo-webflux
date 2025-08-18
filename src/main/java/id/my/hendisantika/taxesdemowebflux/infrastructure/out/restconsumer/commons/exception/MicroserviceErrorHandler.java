package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Map;
import java.util.function.BiFunction;

import static java.util.Map.entry;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.08
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MicroserviceErrorHandler {
    private static final Logger log = LogManager.getLogger(MicroserviceErrorHandler.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static final Map<Class<? extends Throwable>, BiFunction<Throwable, Map<String, Exception>, Exception>> ERROR_MAP =
            Map.ofEntries(
                    entry(WebClientRequestException.class,
                            (ex, map) -> ErrorHandlerUtils.handleRequestError(ex)),
                    entry(WebClientResponseException.BadRequest.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.Unauthorized.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.Forbidden.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.NotFound.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.Conflict.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.BadGateway.class, MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.UnsupportedMediaType.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.NotAcceptable.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.UnprocessableEntity.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.TooManyRequests.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.InternalServerError.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.ServiceUnavailable.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.GatewayTimeout.class,
                            MicroserviceErrorHandler::handleResponseError),
                    entry(WebClientResponseException.class, MicroserviceErrorHandler::handleResponseError)
            );
}
