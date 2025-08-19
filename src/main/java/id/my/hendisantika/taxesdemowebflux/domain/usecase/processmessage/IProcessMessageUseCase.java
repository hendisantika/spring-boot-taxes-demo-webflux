package id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage;

import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.MessageModel;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.38
 * To change this template use File | Settings | File Templates.
 */
public interface IProcessMessageUseCase {

    Mono<Void> processMessage(MessageModel messageModel);
}
