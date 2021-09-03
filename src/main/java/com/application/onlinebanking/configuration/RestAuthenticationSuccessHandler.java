package com.application.onlinebanking.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private static final Log log = LogFactory.getLog(RestAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
			final HttpServletResponse response, final Authentication authentication)
			throws ServletException, IOException {
		// You can do something here for which is success requests
		log.info("Basic Auth Connected successfully");
		
		
	}

}