package id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage;

import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.29
 * To change this template use File | Settings | File Templates.
 */
public interface IApiMessageUseCase {
    Mono<String> sendMessageEvent(String message);

    Mono<String> sendMessageQueue(String message);

    Mono<String> sendMessageEventOther(String message);
}