package id.my.hendisantika.taxesdemowebflux.infrastructure.in.web.holiday.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.47
 * To change this template use File | Settings | File Templates.
 */
@Jacksonized
@Builder(toBuilder = true)
public record HolidayResponseDTO(Integer id,
                                 String year,
                                 LocalDate date,
                                 String state) {
}