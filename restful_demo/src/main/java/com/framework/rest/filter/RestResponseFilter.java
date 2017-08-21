package com.framework.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResponseFilter implements ContainerResponseFilter {

	Logger log = LoggerFactory.getLogger(RestResponseFilter.class);

	public void filter(ContainerRequestContext arg0,
			ContainerResponseContext arg1) throws IOException {
		
		 log.info("jersey2 Response");
	}

}
