package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.exceptionhandler;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.BusinessExceptionMessage;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.ExceptionMessage;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.41
 * To change this template use File | Settings | File Templates.
 */
@Order(-2)
@Component
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    private static final String LOG_CLASS_NAME = GlobalErrorWebExceptionHandler.class.getName();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(
            GlobalErrorWebExceptionHandler.class.getName());
    private final ErrorStatusMapper errorStatusMapper;

    /**
     * Constructs a new GlobalErrorWebExceptionHandler.
     *
     * @param errorAttributes       the error attributes to use for error handling
     * @param applicationContext    the Spring application context
     * @param serverCodecConfigurer the server codec configurer to use for error handling
     */
    public GlobalErrorWebExceptionHandler(DefaultErrorAttributes errorAttributes,
                                          ApplicationContext applicationContext,
                                          ServerCodecConfigurer serverCodecConfigurer,
                                          ErrorStatusMapper errorStatusMapper) {
        super(errorAttributes, new WebProperties.Resources(), applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
        this.errorStatusMapper = errorStatusMapper;
        this.setUpErrorMappings();
    }

    /**
     * Initialize the error mappings assigning the corresponding HTTP status codes for every error.
     * By default, all technical errors are mapped to HTTP status code 500 and
     * all business errors are mapped to HTTP status code 409.
     */
    public void setUpErrorMappings() {
        final List<ExceptionMessage> timeoutListError = List.of(
                TechnicalExceptionMessage.SERVICE_TIMEOUT);

        errorStatusMapper
                .addErrorMappings(Arrays.asList(BusinessExceptionMessage.values()), HttpStatus.CONFLICT)
                .addErrorMappings(Arrays.asList(TechnicalExceptionMessage.values()), HttpStatus.INTERNAL_SERVER_ERROR)
                .addErrorMapping(TechnicalExceptionMessage.BAD_REQUEST, HttpStatus.BAD_REQUEST)
                .addErrorMapping(TechnicalExceptionMessage.MISSING_REQUIRED_HEADERS, HttpStatus.BAD_REQUEST)
                .addErrorMapping(TechnicalExceptionMessage.INVALID_HEADERS_EXCEPTION, HttpStatus.BAD_REQUEST)
                .addErrorMapping(TechnicalExceptionMessage.TECHNICAL_JSON_EXCEPTION, HttpStatus.BAD_REQUEST)
                .addErrorMappings(timeoutListError, HttpStatus.GATEWAY_TIMEOUT);
    }

    /**
     * Gets the routing function to use for error handling.
     *
     * @param errorAttributes the error attributes to use for error handling
     * @return the routing function to use for error handling
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }
}
