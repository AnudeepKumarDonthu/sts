/**
 * 
 */
package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		
		//DetailsService ds= new DetailsServiceImpl();
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DetailsService ds=ac.getBean("detailsService",DetailsService.class);
		System.out.println(ds.findAll().get(0).getfName());

	}

}
