package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.filters;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.13
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class RestClientFilterFunctionLog implements ExchangeFilterFunction {

    private static final Logger logger = Logger.getLogger(RestClientFilterFunctionLog.class.getName());
    private final String componentName;

    @Override
    public @NonNull Mono<ClientResponse> filter(@NonNull ClientRequest request, ExchangeFunction next) {
        var requestSb = new StringBuilder();
        var clientRequest = ClientRequest.from(request)
                .body((out, context) -> request.body().insert(new ClientDecorator(out, requestSb), context))
                .build();
        return next.exchange(clientRequest)
                .flatMap(response -> response.bodyToMono(DataBuffer.class)
                        .defaultIfEmpty(createDefaultDataBuffer())
                        .map(responseBuffer -> {
                            var headersRes = response.headers().asHttpHeaders();
                            if (response.statusCode().isError()) {
                                writeErrorLog(clientRequest, responseBuffer, requestSb, headersRes);
                            } else {
                                writeSuccessfulLog(clientRequest, responseBuffer, requestSb, headersRes);
                            }
                            return ClientResponse.create(response.statusCode())
                                    .headers(headers -> headers.addAll(headersRes))
                                    .body(Flux.just(responseBuffer))
                                    .build();
                        }))
                .onErrorResume(WebClientRequestException.class, ex -> {
                    writeErrorLog(clientRequest, requestSb.toString(), ex);
                    return Mono.error(ex);
                });
    }

    /**
     * Create a default DataBuffer when the response body is empty
     *
     * @return DataBuffer with empty body
     */
    private DataBuffer createDefaultDataBuffer() {
        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
        return dataBufferFactory.wrap(new byte[0]);
    }
}
