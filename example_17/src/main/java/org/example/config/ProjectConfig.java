package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"org.example.Implementation","org.example.services","org.example.Aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
