package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayExternUseCase;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.44
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class HolidayHandler {

    private static final Logger log = LogManager.getLogger(HolidayHandler.class);
    private final IHolidayUseCase holidayUseCase;
    private final IHolidayExternUseCase holidayExternUseCase;
    private final RequestValidator requestValidator;
}
