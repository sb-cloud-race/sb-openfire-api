package io.github.sbcloudrace.sbopenfireapi.persona;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "sb-persona", url = "localhost:8501", path = "/sb-persona")
public interface PersonaServiceProxy {

    @RequestMapping(value = "/personasIdsByUser/{userId}", method = RequestMethod.GET)
    List<Long> personasIdsByUser(@PathVariable Long userId);
}
