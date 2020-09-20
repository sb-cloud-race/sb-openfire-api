package io.github.sbcloudrace.sbopenfireapi.user;

import lombok.AllArgsConstructor;
import org.igniterealtime.restclient.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceProxy userServiceProxy;

    @RequestMapping(value = "/{password}", method = RequestMethod.PUT)
    @ResponseBody
    public void createAllPersonasXmpp(@RequestBody List<Long> personaIds,
                                      @PathVariable String password) {
        personaIds.forEach(aLong -> {
            String xmppUserName = "sbrw.".concat(aLong.toString());
            try {
                UserEntity userEntityTmp = userServiceProxy.get(xmppUserName);
                userEntityTmp.setPassword(password);
                userServiceProxy.update(userEntityTmp, xmppUserName);
            } catch (Exception e) {
                UserEntity userEntity = new UserEntity(
                        xmppUserName,
                        null,
                        null,
                        password);
                userServiceProxy.create(userEntity);
            }
        });
    }
}
