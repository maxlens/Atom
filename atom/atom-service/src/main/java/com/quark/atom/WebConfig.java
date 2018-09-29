package com.quark.atom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
    private Environment env;
 
	public void addCorsMappings(CorsRegistry registry) {
        String urls = env.getProperty("cors.urls");
        CorsRegistration reg = registry.addMapping("/api/**");
        for(String url: urls.split(",")) {
            reg.allowedOrigins(url);
        }
    }
}