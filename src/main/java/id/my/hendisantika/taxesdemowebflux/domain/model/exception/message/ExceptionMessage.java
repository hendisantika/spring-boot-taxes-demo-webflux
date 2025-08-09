package id.my.hendisantika.taxesdemowebflux.domain.model.exception.message;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.20
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionMessage {
    String getCode();

    String getDescription();

    String getMessage();
}
