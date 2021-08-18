package com.example.CRMTorris.security;

import com.example.CRMTorris.exception.security.CookieVerificationFailedException;
import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Log4j
public class CheckAuthCookieFilter implements Filter {

    private static final String VERIFICATION_EXCEPTION = "User not verified";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(httpServletRequest);

        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null && cookies.length > 0) {
            mutableRequest.putHeader(
                    "Authorization", URLDecoder.decode(
                            Arrays.stream(cookies)
                                    .filter(cookie -> cookie.getName().equalsIgnoreCase("auth"))
                                    .findFirst()
                                    .orElseThrow(() -> new CookieVerificationFailedException(VERIFICATION_EXCEPTION))
                                    .getValue(), StandardCharsets.UTF_8));
        }

        chain.doFilter(mutableRequest, response);
    }
}
