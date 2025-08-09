package id.my.hendisantika.taxesdemowebflux.domain.model.holiday.port;

import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.HolidayExternModel;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.22
 * To change this template use File | Settings | File Templates.
 */
public interface IHolidayExternRestPort {
    Mono<List<HolidayExternModel>> getHolidays(String year);
}
