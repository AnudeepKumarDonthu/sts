/**
 * 
 */
package com.org.practice;

/**
 * @author Anudeep Kumar
 *
 */
class MethodClass {
	void stringArg(String s) {
		System.out.println(s + " I am String");

	}

	void stringArg(StringBuffer s) {
		System.out.println(s + " I am StringBuffer");
	}

	void stringArg(StringBuilder s) {
		System.out.println(s + " I am StringBuilder");
	}

	void StringArg2(String s) {
		System.out.println(s+" I am string");

	}

	void StringArg2(Object s) {
		System.out.println(s+" I am Object");

	}
}

public class OverloadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MethodClass mc = new MethodClass();
		mc.stringArg("anudeep");
		mc.stringArg(new StringBuffer("anudeep"));
		mc.stringArg(new StringBuilder("anudeep"));
		mc.StringArg2(null);
		mc.StringArg2("anudeep");
		mc.StringArg2(mc);

	}

}
