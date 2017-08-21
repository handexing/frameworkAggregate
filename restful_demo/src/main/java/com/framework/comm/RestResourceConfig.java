package com.framework.comm;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.rest.filter.RestAuthRequestFilter;
import com.framework.rest.filter.RestResponseFilter;


/**
 * rest register
 */
public class RestResourceConfig extends ResourceConfig {
	Logger log = LoggerFactory.getLogger(RestResourceConfig.class);

    public RestResourceConfig() {
    	log.info("-----------------------------loading JERSEY2 restful---------------------------");
   	 	packages("com.framework.rest.service");
	    register(RestAuthRequestFilter.class);
	    register(RestResponseFilter.class);
	    register(LoggingFilter.class);
	    register(JacksonFeature.class);
	    register(DeflateEncoder.class);
	    EncodingFilter.enableFor(this, GZipEncoder.class);
    }
}