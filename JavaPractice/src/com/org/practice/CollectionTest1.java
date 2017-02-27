/**
 * 
 */
package com.org.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Anudeep Kumar
 *
 */
public class CollectionTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s = new TreeSet<String>();
		Set<String> s1 = new HashSet<String>();
		Integer i = new Integer(10);
		String str=String.valueOf(i);
		String str1=i.toString();
		NavigableSet<String> s2=new TreeSet<String>();
		s.add("donthu");
		s.add("anudeep");
		s.add("abcd");
		s.add("zero");
		s.add("hello");
		s1.add("donthu");
		s1.add("anudeep");
		s1.add("abcd");
		s1.add("zero");
		s1.add("hello");
		System.out.println(s);
		System.out.println(s1);

	}

}
