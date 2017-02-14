package com.practice.reposiroty;

import java.util.List;

import com.practice.model.Details;

public interface HibernateDeatilsRepository {

	List<Details> findAll();

}