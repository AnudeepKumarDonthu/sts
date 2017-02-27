/**
 * 
 */
package com.org.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anudeep Kumar
 *
 */
abstract class X {
	
}
class Y extends X{
	
}
public class NoMainMethod {
	 static {
		System.out.println("I am static Block");
	}
	public static void main(String[] args) {
		Integer i = new Integer(10); //wrapper object
		int j=i.intValue();//unboxing
		int k=1;
		Integer l = Integer.valueOf(k);//boxing
		
		List<String> list = new ArrayList<String>(); //list is non synchronizes
		 for(String s: list){
			 System.out.println(s);
		 }
		
		List listsync= Collections.synchronizedList(list); ////listsync synchronizes
		
	}
	
	

}
