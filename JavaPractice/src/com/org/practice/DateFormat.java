/**
 * 
 */
package com.org.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anudeep Kumar
 *
 */
public class DateFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(new Date());
		System.out.println(sdf.format(new Date()));
		//sdf.f

	}

}
