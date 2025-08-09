package id.my.hendisantika.taxesdemowebflux.domain.model.exception.message;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.Constans;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public enum BusinessExceptionMessage implements ExceptionMessage {
    REQUEST_BODY("NEG0001", "Error in the request body", Constans.REQUEST_BODY_ERROR),
    CHANNEL_TECHNICAL_UNEXPECTED_ERROR("NEG0002", "Server error", Constans.UNEXPECTED_ERROR),
    DATA_NOT_FOUND("NEG0003", "No record found", "No record found"),
    ;
    private final String code;
    private final String description;
    private final String message;
}
