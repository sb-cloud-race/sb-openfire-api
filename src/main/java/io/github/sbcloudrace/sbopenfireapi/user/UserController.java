package io.github.sbcloudrace.sbopenfireapi.user;

import io.github.sbcloudrace.sbopenfireapi.config.SbOpenfireApiProperties;
import lombok.AllArgsConstructor;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceProxy userServiceProxy;
    private final SbOpenfireApiProperties sbOpenfireApiProperties;

    @RequestMapping(value = "/{userId}/{securityToken}", method = RequestMethod.PUT)
    @ResponseBody
    public void createAllPersonasXmpp(@PathVariable Long userId, @PathVariable String securityToken) {
        List<Long> personaIds = new ArrayList<>();
        personaIds.add(100L);
        personaIds.stream().forEach(aLong -> {
            UserEntity userEntity = new UserEntity(
                    "sbrw.".concat(aLong.toString()),
                    null,
                    null,
                    securityToken.substring(0, 16));
            try {
                userServiceProxy.create(userEntity, sbOpenfireApiProperties.getToken());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
