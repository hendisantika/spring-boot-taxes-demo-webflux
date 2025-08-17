package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config.events;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.port.IEventPublisherPort;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.stereotype.Component;

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

}
