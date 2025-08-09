package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.exceptionhandler;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;

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
}
