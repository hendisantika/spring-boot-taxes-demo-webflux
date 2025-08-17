package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.apicalendar;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.28
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiCalendarRequestBuilder {
    static void addCustomHeaders(HttpHeaders httpHeaders) {
        httpHeaders.add("date", new Date().toString());
    }
}
