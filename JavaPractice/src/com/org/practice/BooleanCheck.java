/**
 * 
 */
package com.org.practice;

/**
 * @author Anudeep Kumar
 *
 */
public class BooleanCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isFlag = false;
		for (int i = 1; i <= 10; i++) {
			if (!isFlag && i % 2 == 0) {
				isFlag = true;
				System.out.println(isFlag + " i= "+i);
			} else {
				isFlag = false;
				System.out.println(isFlag + " i= "+i);
			}
		}

	}

}
