package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.TechnicalExceptionMessage;
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
 * Time: 06.11
 * To change this template use File | Settings | File Templates.
 */
@Getter
public class TechnicalRestConsumerException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4115870078189409837L;
    private final TechnicalExceptionMessage technicalExceptionMessage;

    public TechnicalRestConsumerException(Throwable throwable, TechnicalExceptionMessage technicalExceptionMessage) {
        super(technicalExceptionMessage.getMessage(), throwable);
        this.technicalExceptionMessage = technicalExceptionMessage;
    }

    public TechnicalRestConsumerException(String message, TechnicalExceptionMessage technicalExceptionMessage) {
        super(message);
        this.technicalExceptionMessage = technicalExceptionMessage;
    }

    public TechnicalRestConsumerException(TechnicalExceptionMessage technicalExceptionMessage) {
        super(technicalExceptionMessage.getMessage());
        this.technicalExceptionMessage = technicalExceptionMessage;
    }
}
