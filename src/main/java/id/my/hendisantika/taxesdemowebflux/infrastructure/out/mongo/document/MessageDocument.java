package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mongo.document;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.DomainEventModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.messagedata.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "messages")
public class MessageDocument {
    @Id
    private String id;
    private String message;
    private DomainEventModel event;
    private MessageStatus status;
    @Field(name = "created_on")
    private LocalDateTime createdOn;
}
