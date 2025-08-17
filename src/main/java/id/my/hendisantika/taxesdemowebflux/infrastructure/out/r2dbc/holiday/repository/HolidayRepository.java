package id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.holiday.repository;

import id.my.hendisantika.taxesdemowebflux.infrastructure.out.r2dbc.holiday.entity.HolidayEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.25
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface HolidayRepository extends ReactiveCrudRepository<HolidayEntity, Long> {
}
