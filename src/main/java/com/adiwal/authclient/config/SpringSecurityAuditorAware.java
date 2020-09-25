package com.adiwal.authclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Slf4j
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    private final HttpServletRequest httpServletRequest;

    public SpringSecurityAuditorAware(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(httpServletRequest.getUserPrincipal())
                .map(Principal::getName);
    }
}