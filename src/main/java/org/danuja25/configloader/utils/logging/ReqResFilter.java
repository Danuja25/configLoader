package org.danuja25.configloader.utils.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static org.danuja25.configloader.utils.logging.LogUtils.REQUEST_ID_HEADER;

@Component
public class ReqResFilter extends OncePerRequestFilter {

    Logger reqLogger = LoggerFactory.getLogger("RequestLogger");

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String traceId = String.valueOf(UUID.randomUUID());
        httpServletRequest.setAttribute(REQUEST_ID_HEADER,traceId);
        httpServletResponse.addHeader(REQUEST_ID_HEADER,traceId);

        final HttpServletRequestWrapper reqWrapper = new HttpServletRequestWrapper(httpServletRequest) {

            @Override
            public String getHeader(String name) {
                if (REQUEST_ID_HEADER.equals(name)) {
                    return (String) getRequest().getAttribute(REQUEST_ID_HEADER);
                }
                return super.getHeader(name);
            }
        };

        reqLogger.info(LogUtils.formatRequest(reqWrapper));

        filterChain.doFilter(reqWrapper, httpServletResponse);

        reqLogger.info(LogUtils.formatResponse(httpServletResponse));
    }
}