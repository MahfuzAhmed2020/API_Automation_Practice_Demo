package com.osa.utility;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.osa.base.AppContains;

public class Utilities {

	
	/**
	* This method will take HashMap as parameter
	* we know HashMap has key and value, these key and value will be converted as 
	* JSON object key and value, then return as a JSONObject. 
	* @param hm
	* @return
	*/
	public static JSONObject getJsonObject(HashMap<String, String> hm) {
		JSONObject object=new JSONObject(hm);
		return object;
	}
	
	/**
	 * We know sometime we need to add JSON array in json object
	 * This method will convert add any json object we pass in the array
	 * and generate a new JSON array. 
	 */
	public static JSONArray array=new JSONArray();
	
	public static void add(JSONObject obj) {
		array.put(obj);
	}
	
	/**
	 * This method will return the build array that we have generated by using add(JSONObject) method 
	 * @return
	 */
	public static JSONArray getArray() {
		return array;
	}
	/**
	 * thie method will take expected int values and compare them and 
	 * assert then provide the report. 
	 * @param expected
	 * @param actual
	 */
	
	public static void verifyStatu(int expected, int actual) {
		AppContains.LOG.info("Expected value is: "+expected);
		AppContains.LOG.info("Acutal value is: "+actual);
		Assert.assertEquals(actual, expected);
		AppContains.LOG.info("The actual and expected value is matched. ");
	}
	/**
	 * thie method will take expected String values and compare them and 
	 * assert then provide the report. 
	 * @param expected
	 * @param actual
	 */
	public static void verifyStatu(String expected, String actual) {
		AppContains.LOG.info("Expected value is: "+expected);
		AppContains.LOG.info("Acutal value is: "+actual);
		Assert.assertEquals(actual, expected);
		AppContains.LOG.info("The actual and expected value is matched. ");
	}
	public static Logger getLog(Class clazz) {
		Logger log=Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		return log;
	}
	
//	static JSONArray array = new JSONArray();
//
//	public static void main(String[] args) {
//		HashMap<String, String> dayPhone = new HashMap<String, String>();
//		dayPhone.put("Phoone", "3473570373");
//		dayPhone.put("phoneType", "day");
//		add(getJSONObject(dayPhone));
//		HashMap<String, String> nightPhone = new HashMap<String, String>();
//		nightPhone.put("Phone", "718********");
//		nightPhone.put("phoneType", "night");
//		add(getJSONObject(nightPhone));
//
//		JSONObject students = new JSONObject();
//		students.put("firstName", "ifti");
//		students.put("lastName", "abrar");
//		students.put("age", "3");
//		students.put("phoneNumber", getArray());
//		System.out.println(students.get("phoneNumber"));
//	}
//
//	public static JSONObject getJSONObject(HashMap<String, String> object) {
//		JSONObject stu = new JSONObject(object);
//		return stu;
//	}
//
//	public static void add(JSONObject obj) {
//		array.put(obj);
//	}
//
//	public static JSONArray getArray() {
//		return array;
//	}
//	public static Logger getLog(Class clazz) {
//		Logger log=Logger.getLogger(clazz);
//		PropertyConfigurator.configure("src/test/resources/log4j.properties");
//		return log;
//		}
//
}