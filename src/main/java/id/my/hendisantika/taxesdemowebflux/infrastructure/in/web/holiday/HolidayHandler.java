package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayExternUseCase;
import id.my.hendisantika.taxesdemowebflux.domain.usecase.holiday.IHolidayUseCase;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.commons.JsonApiDTO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

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

    public Mono<ServerResponse> getHoliday(ServerRequest serverRequest) {
        //var result = holidayUseCase.getHolidays().collectList();
        //return ServerResponse.ok().body(result, HolidayModel.class);
        return Mono.just(serverRequest)
                .map(rq -> holidayUseCase.getHolidays())
                .flatMapMany(Function.identity())
                .collectList()
                .map(HolidayMapper::buildResponse)
                .map(JsonApiDTO::new)
                .flatMap(ServerResponse.ok()::bodyValue)
                .onErrorResume(Mono::error);
    }
}
