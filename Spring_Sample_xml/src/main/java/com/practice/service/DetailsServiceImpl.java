/**
 * 
 */
package com.practice.service;

import java.util.List;

import com.practice.model.Details;
import com.practice.reposiroty.HibernateDeatilsRepository;

/**
 * @author Anudeep Kumar
 *
 */
public class DetailsServiceImpl implements DetailsService {

	private HibernateDeatilsRepository hdr;

	public DetailsServiceImpl() {

	}

	public DetailsServiceImpl(HibernateDeatilsRepository hdr) {
		this.hdr = hdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.practice.service.DetailsService#findAll()
	 */
	@Override
	public List<Details> findAll() {
		return hdr.findAll();
	}

	public void setHdr(HibernateDeatilsRepository hdr) {
		this.hdr = hdr;
	}

}
