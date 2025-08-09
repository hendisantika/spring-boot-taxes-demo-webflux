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
 * Time: 05.15
 * To change this template use File | Settings | File Templates.
 */
@Getter
public class BusinessException extends RuntimeException {

    private final BusinessExceptionMessage businessExceptionMessage;

    public BusinessException(BusinessExceptionMessage errorMessage) {
        this.businessExceptionMessage = errorMessage;
    }
}
