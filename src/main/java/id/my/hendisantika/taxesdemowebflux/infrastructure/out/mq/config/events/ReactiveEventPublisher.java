package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config.events;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.events.port.IEventPublisherPort;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.12
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventPublisher implements IEventPublisherPort {

    private static final String ROUTING_KEY = "tax.demo.routing.key.event.message";
    private static final String ROUTING_KEY_2 = "tax.demo.routing.key.event.other";
    private static final Logger logger = Logger.getLogger(ReactiveEventPublisher.class.getName());
    private static final String LOG_CLASS_NAME = ReactiveEventPublisher.class.getName();
    private final DomainEventBus domainEventBus;

    @Override
    public <T> Mono<Void> emit(EventModel<T> event) {
        DomainEvent<EventModel<T>> domainEvent = new DomainEvent<>(
                ROUTING_KEY, event.getId(), event);
        return emitDomainEvent(domainEvent);
    }

    @Override
    public <T> Mono<Void> emit(String name, String eventId, T data) {
        DomainEvent<T> domainEvent = new DomainEvent<>(name, eventId, data);
        return emitDomainEvent(domainEvent);
    }

    @Override
    public <T> Mono<Void> emitOtherRouterKey(EventModel<T> event) {
        DomainEvent<EventModel<T>> domainEvent = new DomainEvent<>(
                ROUTING_KEY_2, event.getId(), event);
        return emitDomainEvent(domainEvent);
    }
}
