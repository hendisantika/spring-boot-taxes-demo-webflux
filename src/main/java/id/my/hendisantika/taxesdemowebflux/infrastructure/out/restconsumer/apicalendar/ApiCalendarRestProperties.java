package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.apicalendar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.30
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "rest-consumer.api-calendar")
public class ApiCalendarRestProperties {
    @NotBlank
    private String baseUrl;
    @NotBlank
    private String holiday;
    @Positive
    private int connectTimeout;
    @Positive
    private int responseTimeout;
    @NotBlank
    private String apiKey;
}
