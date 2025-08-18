package id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.holiday.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.HolidayModel;
import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.port.IHolidayRepositoryPort;
import id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.holiday.entity.HolidayEntity;
import id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.holiday.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.18
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class HolidayRepositoryAdapter implements IHolidayRepositoryPort {

    private final HolidayRepository holidayRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Flux<HolidayModel> getHolidays() {
        return holidayRepository.findAll()
                .map(holiday -> objectMapper.map(holiday, HolidayModel.class));
    }

    @Override
    public Mono<HolidayModel> getHolidayById(Integer id) {
        return holidayRepository.findById(id.longValue())
                .map(holiday -> objectMapper.map(holiday, HolidayModel.class));
    }

    @Override
    public Mono<HolidayModel> updateHoliday(HolidayModel holidayModel) {
        return Mono.just(holidayModel)
                .map(h -> h.toBuilder().updatedAt(LocalDateTime.now()).build())
                .map(holiday -> objectMapper.map(holiday, HolidayEntity.class))
                .flatMap(holidayRepository::save)
                .map(holiday -> objectMapper.map(holiday, HolidayModel.class));
    }
}
