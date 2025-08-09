package id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.impl;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.39
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class ProcessMessageUseCase implements IProcessMessageUseCase {

    private final IMessageRepositoryPort messageRepositoryPort;

    /**
     * Process the message.
     *
     * @param messageModel the message model
     * @return the mono
     */
    @Override
    public Mono<Void> processMessage(MessageModel messageModel) {
        return this.messageRepositoryPort.saveMessage(messageModel)
                .then();
    }
}
