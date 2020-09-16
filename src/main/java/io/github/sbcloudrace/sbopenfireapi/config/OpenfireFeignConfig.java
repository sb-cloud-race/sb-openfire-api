package io.github.sbcloudrace.sbopenfireapi.config;

import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
public class OpenfireFeignConfig {

    private final SbOpenfireApiProperties sbOpenfireApiProperties;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Authorization", sbOpenfireApiProperties.getToken());
        };
    }
}
