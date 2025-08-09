package id.my.hendisantika.taxesdemowebflux.domain.model.messagedata;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.DomainEventModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.23
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class MessageModel {
    private String id;
    private String message;
    private DomainEventModel event;
    private MessageStatus status;
    private LocalDateTime createdOn;
}
