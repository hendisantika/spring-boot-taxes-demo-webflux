package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.util;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.BadRequestException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.TechnicalException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
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
 * Time: 05.52
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class RequestValidator {

    private final Validator validator;

    public <T> Mono<T> validateRequestBody(ServerRequest serverRequest, Class<T> clazz) {
        return serverRequest.bodyToMono(clazz)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new TechnicalException(TechnicalExceptionMessage.TECHNICAL_JSON_EXCEPTION))))
                .onErrorMap(e -> new TechnicalException(TechnicalExceptionMessage.TECHNICAL_JSON_EXCEPTION));
    }

    public <T> Mono<T> validateBody(T requestBody) {
        return this.validator.validate(requestBody)
                .stream()
                .findFirst()
                .map(this::buildBadRequestException)
                .orElse(Mono.just(requestBody));
    }

    private <T> Mono<T> buildBadRequestException(ConstraintViolation<T> constraintViolation) {
        String violationPath = constraintViolation.getPropertyPath().toString();
        String violationMessage = constraintViolation.getMessage();
        var exceptionMessage = String.format("%s: %s", violationPath, violationMessage);
        return Mono.error(new BadRequestException(exceptionMessage));
    }
}
