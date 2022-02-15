package com.kowsalya.project;

import java.util.ArrayList;
import java.util.Iterator;

public class TestColle {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("Deepak");
		al.add("Santa");
		al.add("Bhaskaran");
		System.out.println(al);

		Iterator<String> it = al.iterator();

		// hasNext will return true if objects are available

		while (it.hasNext()) {
			System.out.println(it.next());

		}
		
		
		

	}

}
