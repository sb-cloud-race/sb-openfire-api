package io.github.sbcloudrace.sbopenfireapi;

import io.github.sbcloudrace.sbopenfireapi.config.SbOpenfireApiProperties;
import io.github.sbcloudrace.sbopenfireapi.user.UserServiceProxy;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class SbOpenfireApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbOpenfireApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserServiceProxy userServiceProxy, SbOpenfireApiProperties sbOpenfireApiProperties) {
        return args -> {
            String xmppUserName = "sbrw.engine.engine";
            try {
                UserEntity userEntity = userServiceProxy.get(xmppUserName);
                userEntity.setPassword(sbOpenfireApiProperties.getToken());
                userServiceProxy.update(userEntity, xmppUserName);
            } catch (Exception e) {
                UserEntity userEntity = new UserEntity(
                        xmppUserName,
                        null,
                        null,
                        sbOpenfireApiProperties.getToken());
                userServiceProxy.create(userEntity);
            }
        };
    }
}
