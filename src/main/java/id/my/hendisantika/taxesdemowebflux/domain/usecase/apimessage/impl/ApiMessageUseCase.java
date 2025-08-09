package id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage.impl;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.apimessage.IApiMessageUseCase;
import lombok.RequiredArgsConstructor;

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
}
