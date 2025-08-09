package id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage.impl;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage.IApiMessageUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.30
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class ApiMessageUseCase implements IApiMessageUseCase {

    private static final String TYPE_EVENT = "SEND_MESSAGE_EVENT_TEST";
    private static final String TYPE_EVENT_QUEUE = "SEND_MESSAGE_QUEUE_TEST";
    private static final String TYPE_EVENT_OTHER = "SEND_MESSAGE_EVENT_OTHER";
    private final IEventPublisherPort eventPublisherPort;
    private final IQueuePublisherPort queuePublisherPort;
    private final IMessageRepositoryPort messageRepositoryPort;

    @Override
    public Mono<String> sendMessageEvent(String message) {
        return Mono.just(EventUtil.generateEvent(TYPE_EVENT, message))
                .flatMap(event ->
                        saveMessageRepository(event, "sendMessageEvent"))
                .flatMap(eventPublisherPort::emit)
                .thenReturn(message);
    }

    @Override
    public Mono<String> sendMessageQueue(String message) {
        return Mono.just(EventUtil.generateEvent(TYPE_EVENT_QUEUE, message))
                .flatMap(event ->
                        saveMessageRepository(event, "sendMessageQueue"))
                .flatMap(eventPublisherPort::emit)
                .thenReturn(message);
    }

    @Override
    public Mono<String> sendMessageEventOther(String message) {
        return Mono.just(EventUtil.generateEvent(TYPE_EVENT_OTHER, message))
                .flatMap(event ->
                        saveMessageRepository(event, "sendMessageEventOther"))
                .flatMap(eventPublisherPort::emitOtherRouterKey)
                .thenReturn(message);
    }

    private Mono<EventModel> saveMessageRepository(EventModel event, String name) {
        var messageModel = MessageModel.builder()
                .event(DomainEventModel.builder()
                        .name(name)
                        .eventId(event.getId())
                        .data(event.getData())
                        .build())
                .message(event.getData().toString())
                .status(MessageStatus.PENDING)
                .build();
        return this.messageRepositoryPort.saveMessage(messageModel)
                .thenReturn(event);
    }
}
