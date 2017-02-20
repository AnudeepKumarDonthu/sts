/**
 * 
 */
package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.service.DetailsService;

/**
 * @author Anudeep Kumar
 *
 */
public class StartHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// DetailsService ds= new DetailsServiceImpl();
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		DetailsService service = appcontext.getBean("detailsService", DetailsService.class);
		System.out.println(service.findAll().get(0).getfName());
	}

}
