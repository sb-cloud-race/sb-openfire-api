package io.github.sbcloudrace.sbopenfireapi.user;

import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sb-openfire-cli", url = "localhost:9090/plugins/restapi/v1")
public interface UserServiceProxy {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    void create(@RequestBody UserEntity userEntity, @RequestHeader("Authorization") String authToken);
}
