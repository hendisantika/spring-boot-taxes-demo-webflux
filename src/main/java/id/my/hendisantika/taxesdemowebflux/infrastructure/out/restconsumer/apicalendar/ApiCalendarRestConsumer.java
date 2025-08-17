package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.apicalendar;

import id.my.hendisantika.taxesdemowebflux.domain.model.holiday.port.IHolidayExternRestPort;
import io.netty.channel.ChannelOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/08/25
 * Time: 18.29
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ApiCalendarRestConsumer implements IHolidayExternRestPort {

    private static final Logger log = LogManager.getLogger(ApiCalendarRestConsumer.class);
    private final WebClient webClient;
    private final ApiCalendarRestProperties properties;
    private final Map<String, Exception> generateErrorMap;

    public ApiCalendarRestConsumer(@Qualifier("baseWebClient") WebClient baseWebClient,
                                   ApiCalendarRestProperties properties) {
        this.properties = properties;
        this.webClient = baseWebClient.mutate()
                .baseUrl(properties.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                //.filter(CustomFiltersRest.loggingFilter())
                .filter(new RestClientFilterFunctionLog(ApiCalendarRestConsumer.class.getName()))
                .clientConnector(new ReactorClientHttpConnector(setUpHttpClient()))
                .build();

        this.generateErrorMap = Map.of(
                /*"300", new Error1Exception(),
                "301", new Error2Exception(),
                "302", new DataNotFoundWasException(),
                "395", new TransactionTimeExpirationException(),
                "394", new DataCompanyException()*/
        );
    }

    private HttpClient setUpHttpClient() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.getConnectTimeout())
                .responseTimeout(Duration.ofMillis(properties.getResponseTimeout()));
    }
}
