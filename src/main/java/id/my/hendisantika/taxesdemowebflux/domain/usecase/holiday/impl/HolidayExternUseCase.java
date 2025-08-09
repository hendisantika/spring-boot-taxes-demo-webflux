package id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.impl;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayExternUseCase;
import lombok.RequiredArgsConstructor;

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
public class HolidayExternUseCase implements IHolidayExternUseCase {

    private final IHolidayExternRestPort holidayExternRestPort;

    @Override
    public Mono<List<HolidayExternModel>> getHolidays(String year) {
        return holidayExternRestPort.getHolidays(year);
    }
}
