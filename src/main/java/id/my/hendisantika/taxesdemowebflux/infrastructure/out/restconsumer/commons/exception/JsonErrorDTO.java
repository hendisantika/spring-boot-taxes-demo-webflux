package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.List;

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
@Data
@Builder
@Jacksonized
public class JsonErrorDTO<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8906867813073898648L;
    @NonNull
    private List<T> errors;
}
