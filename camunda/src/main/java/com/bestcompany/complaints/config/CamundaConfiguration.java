package com.yourcompany.complaints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.CamundaBpmProperties;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaConfigurator;
import org.camunda.bpm.spring.boot.starter.property.CamundaBpmProperties.Application;

@Configuration
public class CamundaConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
                registry.addResourceHandler("/camunda/app/**")
                        .addResourceLocations("classpath:/META-INF/resources/camunda/app/");
                registry.addResourceHandler("/camunda/app/**")
                        .addResourceLocations("classpath:/META-INF/resources/camunda/app/");
            }
        };
    }

    @Bean
    public CamundaConfigurator customCamundaConfigurator(Application application, CamundaBpmProperties camundaBpmProperties) {
        return new CamundaConfigurator() {
            @Override
            public void preInit(SpringProcessEngineConfiguration processEngineConfiguration) {
                processEngineConfiguration.setDatabaseSchemaUpdate("true");
                processEngineConfiguration.setHistory(camundaBpmProperties.getHistoryLevel());
            }
        };
    }
}
