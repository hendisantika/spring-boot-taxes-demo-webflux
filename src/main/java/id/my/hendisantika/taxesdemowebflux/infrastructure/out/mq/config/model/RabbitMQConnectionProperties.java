package id.my.hendisantika.taxesdemowebflux.infrastructure.out.mq.config.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.10
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
public class RabbitMQConnectionProperties {
    boolean ssl;
    private String virtualhost;
    private String hostname;
    private String password;
    private String username;
    private Integer port;
}
