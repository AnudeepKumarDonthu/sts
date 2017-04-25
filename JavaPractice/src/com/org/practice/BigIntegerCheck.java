/**
 * 
 */
package com.org.practice;

import java.math.BigInteger;

/**
 * @author Anudeep Kumar
 *
 */
public class BigIntegerCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long l = 1234567891234567891l;
		Long lobj = new Long(l);
		long l1 = 1234567891;
		int i = 1234567891;
		Integer iobj = new Integer(i);
		BigInteger bi  = new BigInteger("1234567894787847854785454657651321576513246768765413212");
		System.out.println(bi);
		System.out.println(lobj instanceof Long);
		System.out.println(iobj instanceof Integer);

	}

}
