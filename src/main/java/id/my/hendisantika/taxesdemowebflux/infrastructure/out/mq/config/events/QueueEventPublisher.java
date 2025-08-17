package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config.events;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.port.IQueuePublisherPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.11
 * To change this template use File | Settings | File Templates.
 */
@Component
public class QueueEventPublisher implements IQueuePublisherPort {

    private static final String DIRECT_QUEUE_NAME = "direct";
    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public QueueEventPublisher(RabbitTemplate rabbitTemplate,
                               @Value("${rabbitmq.queue-name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }
}
