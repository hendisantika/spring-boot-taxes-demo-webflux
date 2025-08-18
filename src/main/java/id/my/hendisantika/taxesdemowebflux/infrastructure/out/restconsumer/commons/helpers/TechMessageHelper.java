package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.helpers;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.17
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class TechMessageHelper {

    public static Map<String, Object> getErrorObjectMessage(Throwable error) {
        Map<String, Object> map = new HashMap<>();
        Optional.ofNullable(error.getStackTrace()).ifPresent(trace -> map.put("stackTrace", trace));
        Optional.ofNullable(error.getMessage()).ifPresent(message -> map.put("message", message));
        map.put(LogConstantHelper.EXCEPTION.getName(), error.toString());
        return map;
    }
}
