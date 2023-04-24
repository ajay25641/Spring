package org.example.eazyschool.config;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "eazyschool")
@PropertySource(value="classpath:randomName.properties")
@Validated
public class EazyschoolProps {

    @Min(value=5,message = "Minimum page size should be 5")
    @Max(value=25,message = "Maximum page size should be 25")
    private int pageSize;

    private Map<String,String> contact;

    private List<String> branches;
}
