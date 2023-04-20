package org.example.eazyschool.proxy;


import feign.Headers;
import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.config.ProjectConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact",url="http://localhost:8085/api/contact",configuration = {ProjectConfiguration.class})
public interface ContactProxy {

    @RequestMapping(value="/getMessagesByStatus",method= RequestMethod.GET)
    @Headers(value="Content-Type:application/json")
    public List<Contact> getMessagesByStatus(@RequestParam(name="status") String status);
}
