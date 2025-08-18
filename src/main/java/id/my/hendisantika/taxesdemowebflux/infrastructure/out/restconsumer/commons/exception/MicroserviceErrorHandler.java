package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.08
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MicroserviceErrorHandler {
    private static final Logger log = LogManager.getLogger(MicroserviceErrorHandler.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();
}
