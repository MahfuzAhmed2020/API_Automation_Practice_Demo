package com.zippotam.api;

import org.json.JSONObject;

import com.osa.api.Format;
import com.osa.base.AppContains;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import static io.restassured.RestAssured.*;
public class ZippotamApi {
	public static void main(String[] args) {
		//GET
        
       // RestAssured.baseURI=AppContains.ZIPURL; 
	    RestAssured.baseURI=AppContains.BASE_URI; //osa 
        Response response=RestAssured.given().when().get("/customers/"+"606c6d57e59e500017a120ac").then().statusCode(200).log().all().extract().response();
        
        
	//	AppContains.LOG.info("This is firstName "+response.path("firstName"));
		
//		AppContains.LOG.info("This is lastName "+response.path("lastName"));
//		AppContains.LOG.info("This is phone "+response.path("phone"));
//        AppContains.LOG.info("This is  email "+response.path("email"));
		
     // RestAssured.baseURI=AppContains.BASE_URI; //osa
//		Response response=RestAssured.given().when().get("/in/380013").then().statusCode(200).log().all().extract().response();
//		AppContains.LOG.info("This is get call URL "+response.path("places"));
//		AppContains.LOG.info("This is \"country\" "+response.path("country"));
//		AppContains.LOG.info("This is \"'post code'\""+response.path("'post code'"));
//		AppContains.LOG.info("This is \"places[2].'place name'\" "+response.path("places[2].'place name'"));
		//String get_url="/customers/"+"606c6d57e59e500017a120ac"; 
//		AppContains.LOG.info("This is get call URL "+get_url);
//		Response res_get=	executeRequest("get",get_url);
//		
//		AppContains.LOG.info("This is get call Response "+Format.prettyPrint(res_get));
//	    
	}
	public static Response GET(String endpoint) {
		RestAssured.baseURI=AppContains.BASE_URI;
	    
		Response res=	RestAssured.given().when().get(endpoint).then().statusCode(200).log().all().extract().response();
		
		return res;
	}
	public static Response POST(String endpoint,String payload) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();
		Response res=request
				.contentType(ContentType.JSON)
				.body(payload)
				.post(endpoint);
		return res;
	}
	public static Response DELETE(String endpoint) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();
		Response res=request
				.contentType(ContentType.JSON)
				.delete(endpoint);
		return res;
	}
	public static Response PATCH(String endpoint,String payload) {
		RestAssured.baseURI=AppContains.BASE_URI;
		RequestSpecification request = RestAssured.given();			
		Response res=request
				.contentType(ContentType.JSON)
				.body(payload)
				.patch(endpoint);
		return res;
	}

	public static Response executeRequest(String request, String url) {
		Response res=null; 
		String payload=null;
		String req=request.toLowerCase();
		if(req.equals("get")) {
			res=GET(url);
		}else if(req.equals("post")) {
			res=POST(url,payload);
		}else if(req.equals("patch")) {
			res=PATCH(url,payload);
		}else if(req.equals("delete")) {
			res=DELETE(url);
		}
		//return new JSONObject(res.asString()).toString(4);
		return res;
	}
	public static Response executeRequest(String request, String url, String payload) {
		Response res=null; 
		String req=request.toLowerCase();
		if(req.equals("get")) {
			res=GET(url);
		}else if(req.equals("post")) {
			res=POST(url,payload);
		}else if(req.equals("patch")) {
			res=PATCH(url,payload);
		}else if(req.equals("delete")) {
			res=DELETE(url);
		}
		//return new JSONObject(res.asString()).toString(4);
		return res;
	}
}
