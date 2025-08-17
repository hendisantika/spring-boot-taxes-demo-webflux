package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.repository;

import id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.document.MessageDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.06
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface MessageMongoReactiveRepository extends ReactiveMongoRepository<MessageDocument, String> {
}
