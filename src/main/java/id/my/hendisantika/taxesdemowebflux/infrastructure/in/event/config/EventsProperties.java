package id.my.hendisantika.taxesdemowebflux.infrastructure.in.event.config;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventsName;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.27
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ConfigurationProperties(prefix = "events-entry-points")
@Getter
@Setter
@RequiredArgsConstructor
public class EventsProperties {
    @NotNull
    private final Map<EventsName, String> events;
}
