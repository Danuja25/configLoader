package org.danuja25.configloader.utils.logging;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class LogUtils
{
    private static final String REQUEST_LOG = "~~~REQUEST~~~";
    private static final String RESPONSE_LOG = "~~~RESPONSE~~~";
    static final String REQUEST_ID_HEADER = "requestId";

    private LogUtils() {}

    public static String formatRequest(HttpServletRequestWrapper request)
    {
        return REQUEST_LOG +
                " [ID] : " + request.getHeader(REQUEST_ID_HEADER) +
                " [URI] : " + request.getRequestURI() +
                " [METHOD] : " + request.getMethod();
    }

    public static String formatResponse(HttpServletResponse response)
    {
        return RESPONSE_LOG +
                " [ID] : " + response.getHeader(REQUEST_ID_HEADER) +
                " [STATUS] : " + response.getStatus();
    }


}
