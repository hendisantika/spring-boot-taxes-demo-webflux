package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.helpers;

import lombok.experimental.UtilityClass;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.16
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class JsonSerializerHelper {
    private static final String EMPTY_BODY = "{}";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Object getBodyAsObject(Object jsonBody) {
        Object body = Objects.toString(jsonBody, EMPTY_BODY);
        try {
            if (jsonBody instanceof String) {
                body = objectMapper.readValue(Objects.toString(jsonBody, EMPTY_BODY), Object.class);
            } else if (jsonBody instanceof Map) {
                body = objectMapper.readValue(objectMapper.writeValueAsString(jsonBody), Object.class);
            }
        } catch (JacksonException e) {
            return jsonBody;
        }
        return body;
    }
}
