package com.osa.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

public class Common_Practice {
	public static void main(String[] args) {
		//hashmapDemo();
		listDemo();
	}
	static HashMap<Integer, String> hm = new HashMap<Integer, String>();
	public static void hashmapDemo() {
		
         hm.put(1, "Mahfuz");
		hm.put(2, "Abrar");
		hm.put(3, "Shayan");
	
//		System.out.println(hm.keySet());
//		System.out.println(hm.values());
		for(Entry<Integer, String> ppp : hm.entrySet()) {
			System.out.println(ppp.getKey()+"    "+ppp.getValue());
		}
			}
	static List<String> list=new ArrayList();
	public static void listDemo() {
		
		list.add("Abrar");
		list.add("Ifti");
		System.out.println(list);
		
	}

}
