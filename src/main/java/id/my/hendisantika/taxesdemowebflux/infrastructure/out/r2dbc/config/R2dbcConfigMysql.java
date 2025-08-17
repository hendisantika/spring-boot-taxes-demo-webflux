package id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.15
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableTransactionManagement
@EnableR2dbcRepositories(basePackages = "id.my.hendisantika.taxesdemowebflux.infrastructure")
public class R2dbcConfigMysql {
}
