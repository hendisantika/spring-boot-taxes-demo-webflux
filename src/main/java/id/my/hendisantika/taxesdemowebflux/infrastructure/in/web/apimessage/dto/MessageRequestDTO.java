package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.apimessage.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.37
 * To change this template use File | Settings | File Templates.
 */
@Jacksonized
@Builder(toBuilder = true)
public record MessageRequestDTO(String message) {
}
