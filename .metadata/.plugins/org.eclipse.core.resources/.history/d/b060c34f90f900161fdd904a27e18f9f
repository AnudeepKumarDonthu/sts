/**
 * 
 */
package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Details;
import com.practice.reposiroty.HibernateDeatilsRepository;

/**
 * @author Anudeep Kumar
 *
 */
@Service("detailsService")
public class DetailsServiceImpl implements DetailsService {

	
	private HibernateDeatilsRepository hdr;

	public DetailsServiceImpl() {

	}

	/*public DetailsServiceImpl(HibernateDeatilsRepository hdr) {
		this.hdr = hdr;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.service.DetailsService#findAll()
	 */
	@Override
	public List<Details> findAll() {
		return hdr.findAll();
	}

	//@Autowired
	public void setHdr(HibernateDeatilsRepository hdr) {
		System.out.println("Using setter injection");
		this.hdr = hdr;
	}

	public HibernateDeatilsRepository getHdr() {
		return hdr;
	}

}
