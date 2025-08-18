package id.my.hendisantika.taxesdemowebflux.infrastructure.out.restconsumer.commons.helpers;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 19/08/25
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
@UtilityClass
public class WebExchangeHelper {
    public static String getFirstHeader(ServerRequest request, LogConstantHelper name) {
        return Optional.ofNullable(request)
                .map(ServerRequest::headers)
                .map(headers -> headers.firstHeader(name.getName()))
                .orElse(LogConstantHelper.EMPTY_STRING.getName());
    }

    public static String getFirstHeader(ServerWebExchange exchange, LogConstantHelper name) {
        return Optional.ofNullable(exchange)
                .map(ServerWebExchange::getRequest)
                .map(HttpMessage::getHeaders)
                .map(headers -> headers.getFirst(name.getName()))
                .orElse(LogConstantHelper.EMPTY_STRING.getName());
    }

    private static Object getAttribute(ServerRequest serverRequest, String name) {
        return serverRequest.attribute(name).orElse(LogConstantHelper.EMPTY_STRING.getName());
    }

    private static String formatAppVersion(String appVersion) {
        return String.join(" ", LogConstantHelper.APP_VERSION.getName(), appVersion);
    }

    public static List<String> getTagList(String channel, String appVersion) {
        return List.of(channel, formatAppVersion(appVersion));
    }

    public static List<String> getTagList(ClientRequest clientRequest) {
        String host = clientRequest.url().getHost();
        String method = clientRequest.method().name();
        return List.of(host, method);
    }

    private static Object getAttributeFromExchange(ServerWebExchange exchange, LogConstantHelper name) {
        return Optional.ofNullable(exchange)
                .map(ex -> ex.getAttribute(name.getName()))
                .orElse(LogConstantHelper.EMPTY_JSON.getName());
    }

    public static Map<String, Object> buildRequestMap(ClientRequest request, String requestBody) {
        var requestHeaders = request.headers();
        return Map.of(
                TechnicalLogConstants.BODY, JsonSerializerHelper.getBodyAsObject(requestBody),
                TechnicalLogConstants.HEADERS, requestHeaders.toSingleValueMap()
        );
    }

    public static Map<String, Object> buildResponseMap(String responseBody, HttpHeaders responseHeaders) {
        return Map.of(
                TechnicalLogConstants.BODY, JsonSerializerHelper.getBodyAsObject(responseBody),
                TechnicalLogConstants.HEADERS, responseHeaders.toSingleValueMap()
        );
    }

    public static Map<String, Object> buildErrorResponseMap(WebClientRequestException exception, Throwable rootCause) {
        return Map.of(
                TechnicalLogConstants.BODY, Objects.requireNonNullElse(exception.getMessage(), TechnicalLogConstants.EMPTY),
                TechnicalLogConstants.HEADERS, exception.getHeaders().toSingleValueMap(),
                TechnicalLogConstants.CAUSE, Objects.requireNonNullElse(rootCause.getMessage(), TechnicalLogConstants.EMPTY)
        );
    }

    public static String getFirstHeader(ServerRequest request, String name) {
        return Optional.ofNullable(request)
                .map(ServerRequest::headers)
                .map(headers -> headers.firstHeader(name))
                .orElse(TechnicalLogConstants.EMPTY);
    }

    public static List<String> getTagList(ServerRequest request) {
        String host = request.uri().getHost();
        String method = request.method().name();
        return List.of(host, method);
    }
}
