package id.my.hendisantika.taxesdemowebflux.domain.model.exception.message;

import id.my.hendisantika.taxesdemowebflux.domain.model.exception.Constans;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.20
 * To change this template use File | Settings | File Templates.
 */
@Getter
@RequiredArgsConstructor
public enum TechnicalExceptionMessage implements ExceptionMessage {
    TECHNICAL_SERVER_ERROR("MET0001", "Internal server error", "Internal Server Error"),
    INTERNAL_SERVER_ERROR("TEC0001", "Internal server error", Constans.UNEXPECTED_ERROR),
    RESOURCE_NOT_FOUND("TEC0002", "Trying  to access a nonexistent table or index",
            Constans.RESOURCE_NOT_FOUND_MSG),
    SERVICE_TIMEOUT("TEC0003", "Service Timeout", "Timeout connecting to the service"),
    UNKNOWN_HOST_EXCEPTION("TEC0004", "Unknown host exception", "Host could not be determined"),
    CONNECTION_SERVICE_EXCEPTION("TEC0005", "Connection service exception",
            "An error occurred while attempting to connect to service"),
    SSL_EXCEPTION("TEC0006", "SSL Exception", "An SSL error occurred while attempting to connect to service"),
    ERROR_RESPONSE_COULD_NOT_BE_PARSED("TEC0007", "Error response could not be parsed",
            "An error occurred while attempting to parse the error response"),
    EMPTY_ERROR_RESPONSE("TEC0008", "Empty error response", "The error response is empty"),
    TECHNICAL_JSON_EXCEPTION("TEC0009", "Technical json exception", "Error while parsing the json"),
    BAD_REQUEST("TEC0010", "Bad Request", "Error while validating the data"),
    MISSING_REQUIRED_HEADERS("TEC0011", "Some required header is missing.",
            "Invalid request. All required headers must be sent."),
    INVALID_HEADERS_EXCEPTION("TEC0012", "Invalid Header exception", "Invalid Header exception"),
    REACTIVE_EVENTS_GATEWAY("TEC0013", "Error emitting event", "Exception emitting domain event"),
    TECHNICAL_JSON_DESERIALIZE_EXCEPTION("TEC0014", "Error deserializing message", "Error deserializing message"),

    ;
    private final String code;
    private final String description;
    private final String message;
}
