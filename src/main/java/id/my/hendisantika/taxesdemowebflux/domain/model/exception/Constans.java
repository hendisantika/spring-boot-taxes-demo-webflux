package id.my.hendisantika.taxesdemowebflux.domain.model.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/08/25
 * Time: 05.16
 * To change this template use File | Settings | File Templates.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constans {
    public static final String A_CONVERT_JSONOBJECT_OCCURRED = "Error converting attribute to the desired format";
    public static final String REQUEST_BODY_ERROR = "Error in the request body";
    public static final String UNEXPECTED_ERROR = "Server error";
    public static final String RESOURCE_NOT_FOUND_MSG = "Trying  to access a nonexistent table or index";
    public static final String UNEXPECTED_EXCEPTION_MSG = "Unexpected exception in dynamo services";
    public static final String SDK_EXCEPTION_MSG = "amazon SDK exception related to dynamo service and client";
    public static final String VALIDATE_FORMAT_NAME = "Available format name";
    public static final String INVALIDATE_FORMAT_NAME = "Format name not available";
    public static final String INVALIDATE_FORMAT_NAME_MSG = "The format name already exists";
    public static final String ERROR_UPDATE = "Error updating";
    public static final String INVALID_FORMAT = "Invalid format, please check the entered data.";
    public static final String INVALID_FORMAT_STRUCTURE = "Invalid format structure, please check the entered data.";
}
