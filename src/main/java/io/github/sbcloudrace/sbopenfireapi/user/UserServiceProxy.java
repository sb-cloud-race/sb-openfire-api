package io.github.sbcloudrace.sbopenfireapi.user;

import io.github.sbcloudrace.sbopenfireapi.config.OpenfireFeignConfig;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sb-openfire-cli",
        url = "localhost:9090",
        path = "/plugins/restapi/v1",
        configuration = OpenfireFeignConfig.class)
public interface UserServiceProxy {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    void create(@RequestBody UserEntity userEntity);

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    UserEntity get(@PathVariable("username") String username);

    @RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
    void update(@RequestBody UserEntity userEntity, @PathVariable("username") String username);

}
