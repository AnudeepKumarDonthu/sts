/**
 * 
 */
package com.hibernate.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anudeep Kumar
 *
 */

public class User {

	private int id;
	private String name;
	ProteinData pd = new ProteinData();
	private Set<UserHistory> userHistory = new HashSet<UserHistory>();

	public Set<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(Set<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}

	public ProteinData getPd() {
		return pd;
	}

	public void setPd(ProteinData pd) {
		this.pd = pd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
