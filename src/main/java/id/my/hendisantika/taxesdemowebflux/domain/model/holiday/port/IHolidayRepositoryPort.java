package id.my.hendisantika.taxesdemowebflux.domain.model.holiday.port;

import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.HolidayModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.23
 * To change this template use File | Settings | File Templates.
 */
public interface IHolidayRepositoryPort {
    Flux<HolidayModel> getHolidays();

    Mono<HolidayModel> getHolidayById(Integer id);

    Mono<HolidayModel> updateHoliday(HolidayModel holidayModel);
}
