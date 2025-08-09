package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.exceptionhandler;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.message.ExceptionMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.39
 * To change this template use File | Settings | File Templates.
 */
@Component
@Getter
public class ErrorStatusMapper {

    private final Map<ExceptionMessage, HttpStatus> errorStatusMap;
    private final HttpStatus defaultStatus;

    public ErrorStatusMapper(@Value("${error-status-mapper.default-status}") Integer defaultStatus) {
        this.defaultStatus = HttpStatus.valueOf(defaultStatus);
        this.errorStatusMap = new ConcurrentHashMap<>();
    }

    public ErrorStatusMapper addErrorMapping(ExceptionMessage exceptionMessage, HttpStatus httpStatus) {
        errorStatusMap.put(exceptionMessage, httpStatus);
        return this;
    }
}
