package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.handler;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.DomainEventModel;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
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
 * Time: 05.31
 * To change this template use File | Settings | File Templates.
 */
@Component
@DependsOn("queue")
@RequiredArgsConstructor
public class RabbitMQConsumer {
    private static final Logger logger = Logger.getLogger(RabbitMQConsumer.class.getName());
    private final IProcessMessageUseCase processMessageUseCase;

    @RabbitListener(queues = "#{@rabbitQueueName}")
    public Mono<Void> receiveMessage(DomainEvent<DomainEventModel> event) {
        logger.log(Level.INFO, "📩RabbitListener Mensaje recibido: {0}", new Object[]{event});

        return this.processMessageUseCase.processMessage(
                this.getMessageModel(event)
        ).then();
    }

}
