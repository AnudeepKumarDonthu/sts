/**
 * 
 */
package com.org.practice;

/**
 * @author Anudeep Kumar
 *
 */
public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		a[-10]=10; // Run time array Index out of bound exception
		System.out.println(a[-1]);
	}

}
