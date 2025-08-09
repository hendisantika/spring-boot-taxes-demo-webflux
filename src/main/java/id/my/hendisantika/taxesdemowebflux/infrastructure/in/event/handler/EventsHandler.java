package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.handler;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.DomainEventModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventsName;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config.EventsProperties;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.30
 * To change this template use File | Settings | File Templates.
 */
@EnableEventListeners
@RequiredArgsConstructor
public class EventsHandler {
    private static final String LOG_CLASS_NAME = EventsHandler.class.getName();
    private static final Logger logger = Logger.getLogger(EventsHandler.class.getName());
    private final EventsProperties eventsProperties;
    private final IProcessMessageUseCase processMessageUseCase;

    public Mono<Void> handlerTaxOtherEvent(DomainEvent<DomainEventModel> objectDomainEvent) {
        logger.log(Level.INFO, "📬 Tienes un nuevo mensaje del evento:{0} y routekey: {1}, mensaje: {2}"
                , new Object[]{EventsName.TAX_EVENT_OTHER
                        , eventsProperties.getEvents().get(EventsName.TAX_EVENT_OTHER)
                        , objectDomainEvent});
        var messageModel = this.getMessageModel(objectDomainEvent, "handlerTaxOtherEvent");
        return this.processMessageUseCase
                .processMessage(messageModel)
                .then();
    }

    public Mono<Void> handlerTaxMessage(DomainEvent<DomainEventModel> domainEventDomainEvent) {
        logger.log(Level.INFO, "📮 Tienes un nuevo mensaje del evento: {0} y routekey: {1}, mensaje: {2}"
                , new Object[]{EventsName.TAX_EVENT_OTHER
                        , eventsProperties.getEvents().get(EventsName.TAX_EVENT_OTHER),
                        domainEventDomainEvent});
        return this.processMessageUseCase.processMessage(
                this.getMessageModel(domainEventDomainEvent, "handlerTaxMessage")
        ).then();
    }
}
