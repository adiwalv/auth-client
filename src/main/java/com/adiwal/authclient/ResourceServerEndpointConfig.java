/**
 * © Vikas Adiwal (adiwalv@gmail.com) 2020. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF VIKAS ADIWAL.
 */
package com.adiwal.authclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Configuration
public class ResourceServerEndpointConfig extends ResourceServerConfigurerAdapter {

    // this is the port for management endpoints
    @Value("${management.server.port}")
    private int managementPort;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("port ssec: {}", managementPort);
        http.authorizeRequests()
                .requestMatchers(checkPort(managementPort)).permitAll()
                .anyRequest().authenticated();
    }

    /**
     * This method verifies whether a request port is equal to the provided method parameter
     *
     * @param port Port that needs to be checked with the incoming request port
     * @return Returns a request matcher object with port comparison
     */
    private RequestMatcher checkPort(final int port) {
        return (HttpServletRequest request) -> port == request.getLocalPort();
    }

}
