package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.apimessage;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.36
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class ApiMessageRouter {

    @Bean
    public RouterFunction<ServerResponse> apiMessageRouterFunction(ApiMessageHandler apiMessageHandler) {

        return route().nest(
                accept(APPLICATION_JSON),
                builder -> builder
                        .POST("/send-message-event", apiMessageHandler::sendMessageEvent)
                        .POST("/send-message-queue", apiMessageHandler::sendMessageQueue)
                        .POST("/send-message-event-other", apiMessageHandler::sendMessageEventOther)


        ).build();
    }
}
