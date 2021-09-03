package com.application.onlinebanking.configuration;


import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;



@Component
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private static final Log log = LogFactory.getLog(RestAuthenticationSuccessHandler.class);
	
	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,AuthenticationException exception) throws IOException, ServletException {
		try {
		} catch(Exception e) {
			e.printStackTrace();
			log.error("onAuthenticationFailure", e);
		}
		
	}

}