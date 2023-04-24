package org.example.eazyschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class EasySchoolInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {

        HashMap<String,String>hm=new HashMap<>();

        hm.put("App Name","EasySchool");
        hm.put("version","1.0.0");
        hm.put("contact Mobile","8651789057");
        hm.put("contact Email","ajay25641@gmail.com");

        builder.withDetail("easySchool-info",hm);

    }
}
