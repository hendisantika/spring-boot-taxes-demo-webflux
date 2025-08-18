package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.helpers;

import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TechnicalLogConstants {

    public static final String SERVICE_NAME = "taxes-demo";

    // Technical Log Keys
    public static final String HEADERS = "headers";
    public static final String BODY = "body";
    public static final String TIMESTAMP = "timestamp";

    public static final String TRACE = "trace";
    public static final String CAUSE = "cause";
    public static final String EMPTY = "";
}
