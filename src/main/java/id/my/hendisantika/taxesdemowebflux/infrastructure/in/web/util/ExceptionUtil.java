package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.util;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.BadRequestException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.BusinessException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.TechnicalException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.ErrorList;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.50
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class ExceptionUtil {
    private static final String COLON = ":";

    public Mono<ErrorList.Error> buildErrorFromException(Throwable throwable) {
        return Mono.error(throwable)
                .onErrorResume(BadRequestException.class, ExceptionUtil::buildErrorResponse)
                .onErrorResume(TechnicalException.class, ExceptionUtil::buildErrorResponse)
                .onErrorResume(BusinessException.class, ExceptionUtil::buildErrorResponse)
                //.onErrorResume(RestConsumerException.class, ExceptionUtil::buildErrorResponse)
                .onErrorResume(ExceptionUtil::buildErrorResponse)
                .cast(ErrorList.Error.class);
    }

    public ErrorList.Error addDomain(ServerRequest serverRequest, ErrorList.Error error) {
        return error.toBuilder()
                .domain(String.join(COLON, serverRequest.method().name(), serverRequest.path()))
                .build();
    }

    public Mono<ErrorList.Error> buildErrorResponse(BadRequestException badRequestException) {
        return Mono.just(ErrorList.Error.builder()
                .reason(TechnicalExceptionMessage.BAD_REQUEST.getDescription())
                .code(TechnicalExceptionMessage.BAD_REQUEST.getCode())
                .message(badRequestException.getMessage())
                .build());
    }
}
