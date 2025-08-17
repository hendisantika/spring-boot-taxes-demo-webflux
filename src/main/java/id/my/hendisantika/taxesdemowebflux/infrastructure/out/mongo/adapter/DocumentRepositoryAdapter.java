package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.adapter;

import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.MessageModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.port.IMessageRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.00
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class DocumentRepositoryAdapter implements IMessageRepositoryPort {

    private final MessageMongoReactiveRepository messageMongoReactiveRepository;

    @Override
    public Mono<Void> saveMessage(MessageModel messageModel) {
        MessageDocument messageDocument = MessageDocument.builder()
                .event(messageModel.getEvent())
                .message(messageModel.getEvent().toString())
                .message(messageModel.getMessage())
                .status(messageModel.getStatus())
                .createdOn(LocalDateTime.now())
                .build();
        return this.messageMongoReactiveRepository.save(messageDocument)
                .doOnSuccess(saved -> System.out.println("Message saved: " + saved.getId()))
                .doOnError(error -> System.err.println("Error saving message: " + error.getMessage()))
                .then();

    }
}
