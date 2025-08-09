package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

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
}
