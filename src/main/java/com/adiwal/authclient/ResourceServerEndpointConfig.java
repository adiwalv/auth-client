/**
 * © Vikas Adiwal (adiwalv@gmail.com) 2020. All rights reserved.
 * CONFIDENTIAL AND PROPRIETARY INFORMATION OF VIKAS ADIWAL.
 */
package com.adiwal.authclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerEndpointConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}
