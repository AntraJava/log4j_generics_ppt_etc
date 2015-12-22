package net.antra.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
	public static void main(String[] args) {
		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person());
		List<Student> sList = new ArrayList<>();
		sList.add(new Student());
		TestGenerics.aMethod(pList);
		TestGenerics.aMethod(sList);
		
		List<String> strList = new ArrayList<>();
		strList.add("hello");
		TestGenerics.aMethod(strList);
	}

	static <T> void aMethod(List<? extends T> c){
		T t = c.get(0);
		System.out.println(t.getClass());
	}
}
