package id.my.hendisantika.taxesdemowebflux.domain.model.events.commons;

import id.my.hendisantika.taxesdemowebflux.domain.model.events.EventModel;
import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.12
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class EventUtil {

    public static final String SPEC_VERSION = "1.x-wip";
    public static final String SOURCE = "TAXES-DEMO";
    public static final String APPLICATION_JSON = "application/json";
    public static final String INVOKER = "taxes-demo";
    static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
    static final String AMERICA_ZONE_ID = "Asia/Jakarta";

    public static String getEventDateTimeWithDefaultFormat() {
        return ZonedDateTime.now(ZoneId.of(AMERICA_ZONE_ID)).format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    public <T> EventModel<T> generateEvent(String type, T eventData) {
        return EventModel.<T>builder()
                .id(UUID.randomUUID().toString())
                .invoker(INVOKER)
                .type(type)
                .time(getEventDateTimeWithDefaultFormat())
                .dataContentType(APPLICATION_JSON)
                .source(SOURCE)
                .specVersion(SPEC_VERSION)
                .data(eventData)
                .build();
    }
}
