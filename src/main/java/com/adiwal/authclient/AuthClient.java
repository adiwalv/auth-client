package com.adiwal.authclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableResourceServer
public class AuthClient {

	@Value("${security.tokenUrl}")
	String tokenUrl;

	@Value("${security.clientId}")
	String clientId;

	@Value("${security.clientSecret}")
	String clientSecret;

	@Bean
	public ResourceServerTokenServices tokenService() {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setClientId(clientId);
		tokenServices.setClientSecret(clientSecret);
		tokenServices.setCheckTokenEndpointUrl(tokenUrl);
		return tokenServices;
	}
}
