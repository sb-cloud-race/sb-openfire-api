package io.github.sbcloudrace.sbopenfireapi;

import io.github.sbcloudrace.sbopenfireapi.user.UserServiceProxy;
import org.igniterealtime.restclient.RestApiClient;
import org.igniterealtime.restclient.entity.AuthenticationToken;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SbOpenfireApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbOpenfireApiApplication.class, args);
    }

}
