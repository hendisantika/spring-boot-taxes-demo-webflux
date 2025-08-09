package id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.port;

import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.MessageModel;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.25
 * To change this template use File | Settings | File Templates.
 */
public interface IMessageRepositoryPort {
    Mono<Void> saveMessage(MessageModel messageModel);
}
