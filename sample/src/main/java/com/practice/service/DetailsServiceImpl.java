/**
 * 
 */
package com.practice.service;

import java.util.List;

import com.practice.model.Details;
import com.practice.reposiroty.HibernateDeatilsRepository;
import com.practice.reposiroty.HibernateDeatilsRepositoryImpl;

/**
 * @author Anudeep Kumar
 *
 */
public class DetailsServiceImpl implements DetailsService {
	
	private HibernateDeatilsRepository hdr= new HibernateDeatilsRepositoryImpl();
	/* (non-Javadoc)
	 * @see com.practice.service.DetailsService#findAll()
	 */
	@Override
	public List<Details> findAll(){
		return hdr.findAll();
	}

}
