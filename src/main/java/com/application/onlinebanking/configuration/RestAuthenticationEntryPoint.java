package com.application.onlinebanking.configuration;


import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	
	@SuppressWarnings("deprecation")
	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2) throws IOException, ServletException {
		String error = "Invalid Credentials";
		try {
			String json = String.format("{\"message\": \"%s\"}", error);
			arg1.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			arg1.setContentType("application/json");
			arg1.setCharacterEncoding("UTF-8");
			arg1.getWriter().write(json);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

