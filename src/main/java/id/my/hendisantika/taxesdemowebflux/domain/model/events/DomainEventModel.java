package id.my.hendisantika.taxesdemowebflux.domain.model.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.10
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class DomainEventModel<T> {
    private String name;
    private String eventId;
    private T data;

    @JsonCreator
    public DomainEventModel(@JsonProperty("name") String name,
                            @JsonProperty("eventId") String eventId,
                            @JsonProperty("data") T data) {
        this.name = name;
        this.eventId = eventId;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DomainEventModel{" +
                "name='" + name + '\'' +
                ", eventId='" + eventId + '\'' +
                ", data=" + data +
                '}';
    }
}
