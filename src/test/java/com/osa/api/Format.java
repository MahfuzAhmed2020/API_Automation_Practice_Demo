package com.osa.api;

import java.util.HashMap;

import org.json.JSONObject;

import com.osa.utility.Utilities;

import io.restassured.response.Response;

public class Format {
	public static void main(String[] args) {
		HashMap<String,String> hm=new HashMap<String,String>();
	    hm.put("firstName", "qatar");
	    hm.put("lastName","oman");
	    hm.put("phone","11192022");
	    hm.put("email", "football@gmail.com");
	    String payload=Utilities.getJsonObject(hm).toString();
		System.out.println(prettyPrint(payload));
	}
	
	public static String prettyPrint(Response res) {
		JSONObject response=new JSONObject(res.asString());
		return response.toString(4);	
	}
	public static String prettyPrint(String value) {
		JSONObject response=new JSONObject(value);
		return response.toString(4);
	}
}
