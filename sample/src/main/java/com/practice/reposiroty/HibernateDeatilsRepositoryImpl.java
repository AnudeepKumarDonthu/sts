/**
 * 
 */
package com.practice.reposiroty;

import java.util.ArrayList;
import java.util.List;

import com.practice.model.Details;

/**
 * @author Anudeep Kumar
 *
 */
public class HibernateDeatilsRepositoryImpl implements HibernateDeatilsRepository {

	/* (non-Javadoc)
	 * @see com.practice.reposiroty.HibernateDeatilsRepository#findAll()
	 */
	@Override
	public List<Details> findAll() {
		List<Details> detailsList = new ArrayList<Details>();
		Details d1 = new Details();
		d1.setfName("Anudeep");
		d1.setlName("Kumar");
		Details d2 = new Details();
		d2.setfName("Uma");
		d2.setlName("Akurathi");
		Details d3 = new Details();
		d3.setfName("Avinash");
		d3.setlName("Babu");
		detailsList.add(d1);
		detailsList.add(d2);
		detailsList.add(d3);
		return detailsList;
	}
}
