/**
 * 
 */
package com.org.practice;

/**
 * @author Anudeep Kumar
 *
 */

class C {

}

public class ObjectEqualTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C a1 = new C();
		C a2 = new C();
		C a3 = new C();
		String s="anudeep";
		String s2="anudeep";
		String s1=new String("anudeep");
		if (a1 == a2) {
			System.out.println("a1==a2");
		} else {
			System.out.println("a1!=a2");
		}
		if (a1.equals(a2)) {
			System.out.println("a1.euals(a2)");
		}
		else{
			System.out.println("a1.equals(a2) not");
			}
		
		if (s == s1) {
			System.out.println("s==s1");
		} else {
			System.out.println("s!=s1");
		}
		if (s.equals(s1)) {
			System.out.println("s.equals(s1)");
		}
		else{
			System.out.println("s.equals(s1) not");
			}
		
		
		if (s == s2) {
			System.out.println("s==s2");
		} else {
			System.out.println("s!=s2");
		}
		if (s.equals(s2)) {
			System.out.println("s.equals(s2)");
		}
		else{
			System.out.println("s.equals(s2) not");
			}
	}

}
