package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.util;

import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.52
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class RequestValidator {

    private final Validator validator;

}
