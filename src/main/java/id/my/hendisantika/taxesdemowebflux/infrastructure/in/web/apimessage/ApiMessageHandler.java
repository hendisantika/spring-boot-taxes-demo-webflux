package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.apimessage;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage.IApiMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.35
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class ApiMessageHandler {

    private static final Logger log = LogManager.getLogger(ApiMessageHandler.class);
    private final IApiMessageUseCase apiMessageUseCase;
    private final RequestValidator requestValidator;

    public Mono<ServerResponse> sendMessageEvent(ServerRequest serverRequest) {
        return requestValidator.validateRequestBody(serverRequest, MessageRequestDTO.class)
                .flatMap(messageRequest ->
                        requestValidator.validateBody(messageRequest)
                                .thenReturn(messageRequest))
                .map(MessageRequestDTO::message)
                .flatMap(apiMessageUseCase::sendMessageEvent)
                .map(JsonApiDTO::new)
                .flatMap(ServerResponse.ok()::bodyValue)
                .onErrorResume(Mono::error);
    }
}
