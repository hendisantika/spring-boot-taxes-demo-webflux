package id.my.hendisantika.taxesdemowebflux.domain.model.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.15
 * To change this template use File | Settings | File Templates.
 */
@Getter
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8001278320914303290L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(BusinessExceptionMessage message) {
        super(message.getMessage());
    }
}
