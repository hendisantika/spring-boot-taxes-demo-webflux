package id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.impl;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.DataNotFoundException;
import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.HolidayModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.port.IHolidayRepositoryPort;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.34
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class HolidayUseCase implements IHolidayUseCase {

    private final IHolidayRepositoryPort holidayRepositoryPort;

    @Override
    public Flux<HolidayModel> getHolidays() {
        return holidayRepositoryPort.getHolidays();
    }

    @Override
    public Mono<HolidayModel> getHolidayById(Integer id) {
        return holidayRepositoryPort
                .getHolidayById(id)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new DataNotFoundException())));
    }

    @Override
    public Mono<HolidayModel> updateHoliday(Integer id, HolidayModel holidayModel) {
        return getHolidayById(id)
                .map(h -> h.toBuilder().enabled(holidayModel.getEnabled()).build()
                ).flatMap(holidayRepositoryPort::updateHoliday)
                .onErrorResume(Mono::error);
    }
}
