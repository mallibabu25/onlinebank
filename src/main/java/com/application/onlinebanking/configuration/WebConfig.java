package com.application.onlinebanking.configuration;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
//	@Bean
//	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
//	   webServerFactoryCustomizer() {
//	       return factory -> factory.setContextPath("/");
//	}

//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/resources/**")
//                    .addResourceLocations("/resources/");
//    }

	
}