package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.TechnicalException;
import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import jakarta.annotation.PostConstruct;
import org.reactivecommons.api.domain.DomainEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

import java.util.LinkedHashMap;
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
 * Time: 05.32
 * To change this template use File | Settings | File Templates.
 */
@Component
@DependsOn("queue")
public class ReactiveRabbitMQConsumerHandler {

    private static final Logger logger = Logger.getLogger(ReactiveRabbitMQConsumerHandler.class.getName());
    private final Receiver receiver;
    private final ObjectMapper objectMapper;
    private final String queueName;
    private final IProcessMessageUseCase processMessageUseCase;

    public ReactiveRabbitMQConsumerHandler(Receiver receiver,
                                           ObjectMapper objectMapper,
                                           @Value("${rabbitmq.queue-name}") String queueName,
                                           IProcessMessageUseCase processMessageUseCase
    ) {
        this.receiver = receiver;
        this.objectMapper = objectMapper;
        this.queueName = queueName;
        this.processMessageUseCase = processMessageUseCase;
    }

    @PostConstruct
    public void listenMessages() {
        logger.log(Level.INFO, "✅ Se activa listener para recibir los mensajes de de la cola {0}"
                , new Object[]{queueName});
        receiver.consumeAutoAck(queueName)
                .doOnError(e -> System.err.println("Error al consumir mensajes " +
                        "o Cola no existe: " + e.getMessage()))
                .map(delivery -> convertMessage(delivery.getBody()))
                /*.map(event-> {
                    logger.log(Level.INFO, "📥 Event receive listener: {0}", new Object[]{event});
                    return event;
                })*/
                .flatMap(domainEventModel -> {
                    var messageModel = this.getMessageModel(domainEventModel);
                    return this.processMessageUseCase.processMessage(messageModel)
                            .thenReturn(domainEventModel);
                })
                .doOnNext(event ->
                        logger.log(Level.INFO, "📥 Event receive listener: {0}", new Object[]{event})
                ).subscribe();
    }

    private DomainEvent convertMessage(byte[] body) {
        try {
            return objectMapper.readValue(body, DomainEvent.class);
        } catch (Exception e) {
            throw new TechnicalException(e, TechnicalExceptionMessage.TECHNICAL_JSON_DESERIALIZE_EXCEPTION);
        }
    }

    private EventModel convertMessageModel(LinkedHashMap<String, Object> body) {
        try {
            return objectMapper.convertValue(body, EventModel.class);
        } catch (Exception e) {
            throw new TechnicalException(e, TechnicalExceptionMessage.TECHNICAL_JSON_DESERIALIZE_EXCEPTION);
        }
    }
}
