package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.utility.Utilities;

public class AppContains {
	
	public static final Logger LOG = Utilities.getLog(Utilities.class);
	
	public static final String BASE_URI = PropertyReader.readProperty("baseURI");
	
	public static final String ZIPURL = PropertyReader.readProperty("zipURL");




}
