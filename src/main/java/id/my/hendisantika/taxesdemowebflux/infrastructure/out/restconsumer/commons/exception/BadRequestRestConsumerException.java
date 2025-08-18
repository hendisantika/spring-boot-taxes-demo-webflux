package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.05
 * To change this template use File | Settings | File Templates.
 */
@Getter
public class BadRequestRestConsumerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8001278320914303290L;

    public BadRequestRestConsumerException(String message) {
        super(message);
    }
}
