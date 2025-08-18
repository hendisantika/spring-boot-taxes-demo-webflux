package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

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
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@Builder
@Jacksonized
public class ErrorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7671088549957738261L;
    private String reason;
    private String domain;
    private String code;
    private String message;
    private String type;
}
