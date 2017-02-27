/**
 * 
 */
package com.org.practice;


/**
 * @author Anudeep Kumar
 *
 */
public class AddNumbersInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "anudeep123donthu2466";
		 int sum = 0;
		 int evenSum = 0;
		 for (char c : a.replaceAll("\\D", "").toCharArray()) {
		     int digit = c - '0';
		     System.out.println(digit);
		     sum += digit;
		     if (digit % 2 == 0) {
		         evenSum += digit;
		     }
		 }
		 System.out.println(a);
		 System.out.println(sum);
		 System.out.println(evenSum);
	}

}
