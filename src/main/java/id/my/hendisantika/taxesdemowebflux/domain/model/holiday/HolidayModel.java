package id.my.hendisantika.taxesdemowebflux.domain.model.holiday;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class HolidayModel {
    private Integer id;
    private String year;
    private LocalDate date;
    private Short enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer idUserCreate;
    private Integer idUserUpdate;
}
