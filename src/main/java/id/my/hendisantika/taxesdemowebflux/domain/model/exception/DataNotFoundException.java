package id.my.hendisantika.taxesdemowebflux.domain.model.exception;

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
public class DataNotFoundException extends BusinessException {
    public DataNotFoundException() {
        super(BusinessExceptionMessage.DATA_NOT_FOUND);
    }

    @Override
    public String getMessage() {
        return BusinessExceptionMessage.DATA_NOT_FOUND.getMessage();
    }
}
