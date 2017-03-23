/**
 * 
 */
package com.hibernate.practice;

import java.util.Date;

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
		u.setId(2);
		u.setName("anudeep");
		u.getPd().setTotal(10);
		u.getPd().setGoal(100);
		u.getUserHistory().add(new UserHistory(new Date(), "Set Goal 1"));
		session.save(u);
		System.out.println("User details saved successfully");
		session.getTransaction().commit();
		session.close();

	}

}
