package com.tubanurbalci.exampleconsume.proxy;

import com.tubanurbalci.exampleconsume.config.ProjectConfiguration;
import com.tubanurbalci.exampleconsume.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "contact", url="http://localhost:8080/api/contact", configuration= ProjectConfiguration.class)
public interface ContactProxy {

    @RequestMapping (method = RequestMethod.GET, value = "/getMessagesByStatus")
    @Headers(value = "Content-Type: application/json")
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status);

}
