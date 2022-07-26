package com.hashmap.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class HashmapPractice {
	public static void main(String[] args) {
//		Map<Integer, String> hm = new HashMap<Integer, String>();
//		hm.put(1, "mahfuz");
//		hm.put(2, "abrar");
//	System.out.println(hm.keySet()+" "+hm.values());
// System.out.println(hm);
////if you want to read both key and value using entrySet() method
//		for (Map.Entry<Integer, String> entry : hm.entrySet()) {
//			System.out.println(entry.getKey() +"  "+ entry.getValue());
//		}
//		for(String v:hm.values()) {
//			System.out.println("v= "+v);
//		}
		//studentList();
		
		System.out.println(convertJSONOBJECT().toString(4));
	}
	

	public static Map<String, List<String>> studentList() {
         List <String> student=new ArrayList<String>();
		 student.add("mahfuz");
		 student.add("habib");
		 List <String> teacher=new ArrayList<String>();
		 teacher.add("mitul");
		 teacher.add("shamin");
		 Map<String,List<String>> lhm=new HashMap<String,List<String>>();
		 lhm.put("Student", student);
		 lhm.put("teacher", teacher);
		 return lhm;
		}
	public static JSONObject convertJSONOBJECT() {
//		HashMap<String,String> hm=new HashMap<String,String>();
//		hm.put("a", "1");
//		hm.put("b", "2");
		JSONObject jo=new JSONObject(studentList());
		return jo;
	}
	static JSONArray ja=new JSONArray();
	public static void add() {
		ja.put("");
	}

}
