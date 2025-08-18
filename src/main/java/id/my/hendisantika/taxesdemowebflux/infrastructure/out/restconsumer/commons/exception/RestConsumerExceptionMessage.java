package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.ExceptionMessage;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.11
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
public class RestConsumerExceptionMessage implements ExceptionMessage, Serializable {

    @Serial
    private static final long serialVersionUID = -2248294343700910526L;

    private String code;
    private String message;
    private String description;
    private String httpStatus;
}
