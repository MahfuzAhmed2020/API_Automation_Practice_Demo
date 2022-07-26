package osa.students.hm;

import java.util.HashMap;
import java.util.Map;

public class Osa {
	public static void main(String[] args) {
		Map <Integer,Osa_Students> stu=getStudents();
		
		for (int i=0;i<stu.size();i++) {
			System.out.println(stu.get(i).getFirstName()+" "+stu.get(i).getLastName()+" "+stu.get(i).getAge()+" ");	
		}	
		
	}
public static HashMap<Integer, Osa_Students> getStudents() {
	HashMap <Integer,Osa_Students> pp=new HashMap <Integer,Osa_Students>();
	pp.put(0, new Osa_Students("ilhan","omar","55"));
	pp.put(1, new Osa_Students("joe","biden","88"));
	return pp;
}
}
