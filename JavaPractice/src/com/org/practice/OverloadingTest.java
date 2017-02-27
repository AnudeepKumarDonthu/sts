/**
 * 
 */
package com.org.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anudeep Kumar
 *
 */
class SuperClass {
	public void defaultMethod() {
		System.out.println("SuperClass defaultMethod");
	}
}

class SubClass extends SuperClass {
	public void defaultMethod() {
		
		System.out.println("SubClass defaultMethod");

	}
public void defaultMethod2() {
		
		System.out.println("SubClass defaultMethod");

	}
}
interface inter{
	
	public abstract void Interfacemethod();
	
}

public class OverloadingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuperClass sp = new SuperClass();
		SubClass sb= new SubClass();
		SuperClass spr= new SubClass();
		List<SuperClass> l1= new ArrayList<SuperClass>();
		List<SubClass> l2= new ArrayList<SubClass>();
		l1.add(sb);
		//l2.add(sp);
//		spr.defaultMethod2();
		sp.defaultMethod();
		sb.defaultMethod();
		spr.defaultMethod();
		

	}

}
