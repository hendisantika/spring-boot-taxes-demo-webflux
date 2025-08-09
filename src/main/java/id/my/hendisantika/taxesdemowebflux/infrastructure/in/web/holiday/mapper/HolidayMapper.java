package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday.mapper;

import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.HolidayModel;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.commons.JsonApiDTO;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday.dto.HolidayResponseDTO;
import id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday.dto.HolidayUpdateRequestDTO;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.48
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class HolidayMapper {
    public static List<HolidayResponseDTO> buildResponse(List<HolidayModel> holidays) {
        return holidays.stream()
                .map(holiday ->
                        new HolidayResponseDTO(
                                holiday.getId(),
                                holiday.getYear(),
                                holiday.getDate(),
                                holiday.getEnabled().intValue() == 1 ? "A" : "I"
                        )
                )
                .toList();
    }

    public static HolidayResponseDTO buildResponseData(HolidayModel holiday) {
        return new HolidayResponseDTO(
                holiday.getId(),
                holiday.getYear(),
                holiday.getDate(),
                holiday.getEnabled().intValue() == 1 ? "A" : "I"
        );
    }

    public static HolidayModel buildHolidayModel(HolidayUpdateRequestDTO holidayUpdate) {
        return HolidayModel.builder()
                .enabled(holidayUpdate.getState())
                .id(holidayUpdate.getId())
                .build();
    }

    public static <T> JsonApiDTO<T> buildResponseData(T object) {
        return new JsonApiDTO<>(object);
    }
}
