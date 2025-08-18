package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.TechnicalException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.NoArgsConstructor;

import javax.net.ssl.SSLException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertPathBuilderException;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ErrorHandlerUtils {
    private static final Map<Class<? extends Throwable>, Function<Throwable, Exception>> REQUEST_ERROR_MAP =
            Map.of(
                    ReadTimeoutException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.SERVICE_TIMEOUT),
                    SocketTimeoutException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.SERVICE_TIMEOUT),
                    UnknownHostException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.UNKNOWN_HOST_EXCEPTION),
                    ConnectException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.CONNECTION_SERVICE_EXCEPTION),
                    SSLException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.SSL_EXCEPTION),
                    CertPathBuilderException.class, ex -> new TechnicalException(ex, TechnicalExceptionMessage.SSL_EXCEPTION)
            );

}
