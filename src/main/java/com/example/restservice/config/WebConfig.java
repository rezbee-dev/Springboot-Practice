package com.example.restservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

}

// Can also add controllers to the main method/ class
//@SpringBootApplication
//public class TacoCloudApplication implements WebMvcConfigurer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(TacoCloudApplication.class, args);
//    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("home");
//    }
//
//}