package id.my.hendisantika.taxesdemowebflux.domain.model.exception;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.18
 * To change this template use File | Settings | File Templates.
 */
@Getter
public class TechnicalException extends RuntimeException {
    private final TechnicalExceptionMessage technicalExceptionMessage;

    public TechnicalException(Throwable throwable, TechnicalExceptionMessage technicalExceptionMessage) {
        super(technicalExceptionMessage.getMessage(), throwable);
        this.technicalExceptionMessage = technicalExceptionMessage;
    }

    public TechnicalException(String message, TechnicalExceptionMessage technicalExceptionMessage) {
        super(message);
        this.technicalExceptionMessage = technicalExceptionMessage;
    }

    public TechnicalException(TechnicalExceptionMessage technicalExceptionMessage) {
        super(technicalExceptionMessage.getMessage());
        this.technicalExceptionMessage = technicalExceptionMessage;
    }
}
