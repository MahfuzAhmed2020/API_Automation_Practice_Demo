package com.osa.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.osa.base.AppContains;
import com.osa.utility.Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Apis {
	

	/**
	 * POST
	 * GET
	 * PATCH
	 * GET
	 * DELETE
	 * GET
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Post call
//		HashMap<String,String> hm=new HashMap<String,String>();
//	    hm.put("firstName", "Habib");
//	    hm.put("lastName","Mahfuz");
//	    hm.put("phone","4545656567");
//	    hm.put("email", "masum@yahoo.com");
//	    Response post=POST("/customers",myPayload(hm));
//		System.out.println(post.getStatusCode());
//		System.out.println("Response: "+post.asString());
//	Response get=GET("/customers/60664e7a673829001730d560");
//	JSONObject getRe = new JSONObject(get.asString());
//	AppContains.LOG.info("==========Before change===========");
//	AppContains.LOG.info(getRe.toString(4));
//	
//	//Utilities.verifyStatuCode(200, get.getStatusCode());
//		//Patch call
//	HashMap<String,String> hm=new HashMap<String,String>();
//	    hm.put("firstName", "Md");
//	    hm.put("lastName","Habib");
//	    hm.put("phone","4567678878");
//	    hm.put("email", "habib@yahoo.com");
//	    JSONObject payload=Utilities.getJsonObject(hm);
//		System.out.println("==========During change===========");
//	Response patch=PATCH("customers/60664e7a673829001730d560",payload);
//	JSONObject patch1 = new JSONObject(patch.asString());
//	System.out.println(patch1.toString(4));
//	System.out.println("==========After change===========");
//	Response get1=GET("/customers/60664e7a673829001730d560");
//	JSONObject get11 = new JSONObject(get1.asString());
//	System.out.println(get11.toString(4));
	
	//Delete call
//	Response delete=DELETE("/customers/6060c3a7e516d40017d03f72");
//	System.out.println(delete.getStatusCode());
//	System.out.println("Response: "+delete.asString());
		
		
		 
		
	   
		HashMap<String,String> hm=new HashMap<String,String>();
	    hm.put("firstName", "qatar");
	    hm.put("lastName","oman");
	    hm.put("phone","11192022");
	    hm.put("email", "football@gmail.com");
	    String payload=Utilities.getJsonObject(hm).toString();

	  
		HashMap<String,String> hm1=new HashMap<String,String>();
	    hm1.put("firstName", "brazil");
	    hm1.put("lastName","argentina");
	    hm1.put("phone","11192022");
	    hm1.put("email", "goal@gmail.com");
	    String payload_patch=Utilities.getJsonObject(hm1).toString();
	    
	    
	    //POST
	    AppContains.LOG.info("This is the POST call Payload "+Format.prettyPrint(payload));
	    Response res_post=executeRequest("post","/customers",payload);
	   // Response res_post=  POST("/customers",payload);
	    AppContains.LOG.info("This is post response "+Format.prettyPrint(res_post));
	    
	    
	    
	    //GET
	    String get_url="/customers/"+res_post.jsonPath().get("_id");
		//String get_url="/customers/"+"606c6d57e59e500017a120ac";            //with id
		//String get_url="/de/"+ "24848";                                 //URL for zippotom
	    AppContains.LOG.info("This is get call URL "+get_url);
	    Response res_get=executeRequest("get",get_url);
	    AppContains.LOG.info("This is get call Response "+Format.prettyPrint(res_get));
	    
	    //PATCH
	    String patch_url="/customers/"+res_post.jsonPath().get("_id"); 
	   // String patch_url= "/customers/"+"606c6d57e59e500017a120ac";
	    AppContains.LOG.info("This is the Patch call Payload "+Format.prettyPrint(payload_patch));
	    AppContains.LOG.info("This is the Patch call URL "+patch_url);
	    Response res_patch=executeRequest("patch",patch_url,payload_patch);
	    AppContains.LOG.info("This is Patch call response "+Format.prettyPrint(res_patch));
	    
	  //GET
		 String get_url1="/customers/"+res_patch.jsonPath().get("_id");
	    // String get_url1=patch_url; //    "/customers/"+ "606ae9d8ea8f7d0017bc6e0c";
		 AppContains.LOG.info("This is get call URL "+get_url1);
		 Response res_get1=executeRequest("Get",get_url1);
		 AppContains.LOG.info("This is get call Response "+Format.prettyPrint(res_get1));
		
		    
	    
//	    //DELETE
//	    AppContains.LOG.info("This is DELETE call URL "+res_patch); 
//		Response res_delete=executeRequest("delete",patch_url);
//		AppContains.LOG.info("This is DELETE call response "+Format.prettyPrint(res_delete));
	

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
	
	public static Response GET(String endpoint) {
		RestAssured.baseURI=AppContains.BASE_URI;
	   // RestAssured.baseURI=AppContains.ZIPURL;
		RequestSpecification request= RestAssured.given();
		Response res=request.get(endpoint);
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

}
