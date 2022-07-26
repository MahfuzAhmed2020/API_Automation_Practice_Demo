package com.hashmap.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import osa.students.hm.Osa_Students;

public class HashMapDemo {
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add(0, "mahfuz");
		li.add(1, "Ahmed");

//		ListUserInput liu=new ListUserInput("","");
//		liu.setEmail("uk.usa@gmail.com");
//		System.out.println(liu.getEmail());

		for (int i = 0; i < li.size(); i++) {
			System.out.println(i + "  " + li.get(i) + "\n****************");
		}

		HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>();
		hm.put(1, li);
		hm.put(0, li);
		for (int i = 0; i < hm.size(); i++) {
			System.out.println(hm.get(i) + "            " + hm.get(i) + "\n###################");
		}
		System.out.println("hm  " + hm + "\n^^^^^^^^^^^^^^^^");

		HashMap<Integer, ListUserInput> stu = getStudents();
		for (int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i).getName() + "            " + stu.get(i).getEmail() + "\n###################");
		}

		System.out.println(convertJSONOBJECT().toString(4));
	}

	public static JSONObject convertJSONOBJECT() {
//		HashMap<String,String> hm=new HashMap<String,String>();
//		hm.put("a", "1");
//		hm.put("b", "2");
		//JSONObject jo = new JSONObject(getStudents());
		JSONObject jo = new JSONObject(studentList());
		return jo;
	}

	public static Map<String, List<String>> studentList() {
		List<String> student = new ArrayList<String>();
		student.add("mahfuz");
		student.add("habib");
		List<String> teacher = new ArrayList<String>();
		teacher.add("mitul");
		teacher.add("shamim");
		Map<String, List<String>> lhm = new HashMap<String, List<String>>();
		lhm.put("Student", student);
		lhm.put("teacher", teacher);
		return lhm;
	}

	public static HashMap<Integer, ListUserInput> getStudents() {
		HashMap<Integer, ListUserInput> pp = new HashMap<Integer, ListUserInput>();
		pp.put(0, new ListUserInput("rahim", "rahim@yahoo.com"));
		pp.put(1, new ListUserInput("karim", "karim@gmail.cm"));

		return pp;
	}

	static JSONArray ja = new JSONArray();

	public static void add() {
		ja.put("");
	}

}
