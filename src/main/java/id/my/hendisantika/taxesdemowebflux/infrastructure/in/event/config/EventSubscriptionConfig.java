package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.DomainEventModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventsName;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.reactivecommons.async.api.HandlerRegistry.register;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.26
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class EventSubscriptionConfig {

    private final EventsProperties eventsProperties;
    //private static final Logger logger = Logger.getLogger(EventSubscriptionConfig.class.getName());


    @Bean
    public HandlerRegistry handleEventSubscriptions(EventsHandler eventsHandler) {
        final var events = eventsProperties.getEvents();

        return register().listenEvent(events.get(EventsName.TAX_EVENT_OTHER),
                        eventsHandler::handlerTaxOtherEvent, DomainEventModel.class)
                .listenEvent(events.get(EventsName.TAX_EVENT_MESSAGE),
                        eventsHandler::handlerTaxMessage, DomainEventModel.class)
                ;
    }
}
