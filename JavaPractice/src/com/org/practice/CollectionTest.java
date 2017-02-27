/**
 * 
 */
package com.org.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anudeep Kumar
 *
 */
public class CollectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		List<String> l = new ArrayList<>();
		s.add("anudeep");
		s.add("anudeep");
		s.add("donthu");
		l.add("anudeep");
		l.add("anudeep");
		l.add("donthu");
		System.out.println(s);
		System.out.println(l);
		
	}

}
