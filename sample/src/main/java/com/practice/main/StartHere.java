/**
 * 
 */
package com.practice.main;

import com.practice.service.DetailsService;
import com.practice.service.DetailsServiceImpl;

/**
 * @author Anudeep Kumar
 *
 */
public class StartHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DetailsService ds= new DetailsServiceImpl();
		System.out.println(ds.findAll().get(0).getfName());

	}

}