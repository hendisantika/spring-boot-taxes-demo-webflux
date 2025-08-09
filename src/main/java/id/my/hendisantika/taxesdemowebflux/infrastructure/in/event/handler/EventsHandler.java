package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.handler;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config.EventsProperties;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;

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
}
