/**
 * 
 */
package com.hibernate.practice;

import org.hibernate.Session;

/**
 * @author Anudeep Kumar
 *
 */
public class HibernateOne {

	public static void main(String[] args) {
		
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		User u = new User();
		u.setId(1);
		u.setName("anudeep");
		u.setTotal(10);
		u.setGoal(100);
		session.save(u);
		System.out.println("User details saved successfully");
		session.getTransaction().commit();
		session.close();

	}

}
