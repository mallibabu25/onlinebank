package com.application.onlinebanking.configuration;

import java.util.Arrays;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.application.common.LoginService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	static String[] exclusions = new String[] {
			"/*.css","/*.js","/login",
			"/transaction/proceedtoPay",
			"/transaction/redirectingPaymentGate",
			"/transaction/atom/callback",
			"/transaction/payment**",
			"/transactionrest/getTransactionDetailsById",
			"/transactionrest/payment**",
			"/schoolrest/getAllPlans"
	};

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    
    @Configuration
    @Order(1)
    public static class ApiTokenSecurityConfig extends WebSecurityConfigurerAdapter{
    	@Bean
	    public RestAuthenticationEntryPoint restServicesEntryPoint() {
	    	return new RestAuthenticationEntryPoint();
	    }
	    
	    @Bean
	    public RestAuthenticationSuccessHandler mySuccessHandler() {
	    	return new RestAuthenticationSuccessHandler();
	    }
	    @Bean
        public RestAuthenticationFailureHandler myFailureHandler() {
            return new RestAuthenticationFailureHandler();
        }
	    @Bean
	    public RestAuthenticationAccessDeniedHandler myAuthenticationAccessDeniedHandler() {
	    	return new RestAuthenticationAccessDeniedHandler();
	    }
	    
	    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
            		.cors().and()
            		.antMatcher("/*rest/**")
		            .httpBasic().authenticationEntryPoint(restServicesEntryPoint())
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .formLogin().successHandler(mySuccessHandler()).failureHandler(myFailureHandler())
                    .and()
                    .anonymous().disable()
                    .exceptionHandling()
                    .accessDeniedHandler(myAuthenticationAccessDeniedHandler())
                    .and()
                    .csrf().disable();
                    /* other config options go here... */
        }

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
        .antMatchers(exclusions); // #3
    }
    
    
    
    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			 http
	         .authorizeRequests()
	         .antMatchers(exclusions)
	          .permitAll()
	          		.antMatchers("/**").authenticated()
	           .and()
	           .formLogin()
	           .loginProcessingUrl("/perform_login")
	           	.loginPage("/login")
	           	.defaultSuccessUrl("/checkLogin",true)
	           	.failureUrl("/login?msg=Invalid Credentials")
	           
	           .and()
	           .logout()
	           	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	           	.deleteCookies("JSESSIONID")
	           	.invalidateHttpSession(true)
	           	.logoutSuccessUrl("/login")
	           .and()
	           .sessionManagement()
	           .invalidSessionUrl("/login")
	           .and()
	           .cors().and()
	           .csrf().disable();
		}
    }
	
	@Bean 
	public PasswordEncoder  passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder();
		auth.userDetailsService(loginService).passwordEncoder(encoder);
	}

	
}