package id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday;

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
 * Date: 09/08/25
 * Time: 13.33
 * To change this template use File | Settings | File Templates.
 */
public interface IHolidayExternUseCase {
    Mono<List<HolidayExternModel>> getHolidays(String year);
}
