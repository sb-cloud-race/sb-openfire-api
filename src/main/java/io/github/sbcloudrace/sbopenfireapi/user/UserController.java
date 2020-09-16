package io.github.sbcloudrace.sbopenfireapi.user;

import io.github.sbcloudrace.sbopenfireapi.config.SbOpenfireApiProperties;
import lombok.AllArgsConstructor;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/{userId}/{securityToken}", method = RequestMethod.PUT)
    @ResponseBody
    public void createAllPersonasXmpp(@PathVariable Long userId, @PathVariable String securityToken) {
        List<Long> personaIds = new ArrayList<>();
        personaIds.add(100L);
        personaIds.stream().forEach(aLong -> {
            String xmppUserName = "sbrw.".concat(aLong.toString());
            UserEntity userEntityTmp = userServiceProxy.get(xmppUserName);
            if (userEntityTmp != null) {
                System.out.println("atualizaaaa");
                //userEntityTmp
            } else {
                UserEntity userEntity = new UserEntity(
                        xmppUserName,
                        null,
                        null,
                        securityToken.substring(0, 16));
                userServiceProxy.create(userEntity);
            }

        });
    }
}
