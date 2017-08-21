package com.framework.rest.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestAuthRequestFilter implements ContainerRequestFilter {
	Logger log = LoggerFactory.getLogger(RestAuthRequestFilter.class);

	@Context HttpHeaders httpHeaders;  
	@Context SecurityContext sc;   
	@Context HttpServletResponse response;  
	@Context HttpServletRequest request; 
	public void filter(ContainerRequestContext requestContext)
			throws IOException {

		String headerString = requestContext.getHeaderString("content-type");
        if (headerString != null) {
           if (headerString.startsWith(MediaType.APPLICATION_FORM_URLENCODED))
        	   requestContext.getHeaders().putSingle("content-type", MediaType.APPLICATION_FORM_URLENCODED);
        }
      
        log.info("RESTFUL接口请求 RequestURL：{}",request.getRequestURL());
        log.info("[RESTFUL] RequestAddr:{}",request.getRemoteAddr());

	}
}

