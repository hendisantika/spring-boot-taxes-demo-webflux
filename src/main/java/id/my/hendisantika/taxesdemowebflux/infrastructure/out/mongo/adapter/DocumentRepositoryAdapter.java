package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.adapter;

import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.port.IMessageRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
