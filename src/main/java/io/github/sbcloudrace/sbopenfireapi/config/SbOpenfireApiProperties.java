package io.github.sbcloudrace.sbopenfireapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sb-openfire-api")
@Getter
@Setter
public class SbOpenfireApiProperties {
    private String token;
}
