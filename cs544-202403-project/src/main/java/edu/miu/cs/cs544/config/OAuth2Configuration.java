package edu.miu.cs.cs544.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuth2Configuration {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = ClientRegistration
                .withRegistrationId("your-registration-id")
                .clientId("your-client-id")
                .clientSecret("your-client-secret")
                // Add other configuration properties as needed
                .build();

        return new InMemoryClientRegistrationRepository(clientRegistration);
    }
}

