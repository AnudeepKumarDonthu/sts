/**
 * 
 */
package com.practice.main;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.practice.reposiroty.HibernateDeatilsRepository;
import com.practice.reposiroty.HibernateDeatilsRepositoryImpl;
import com.practice.service.DetailsService;
import com.practice.service.DetailsServiceImpl;

/**
 * @author Anudeep Kumar
 *
 */
@Configuration
@ComponentScan({"com.practice"})
public class AppConfig {
	
	@Bean(name="detailsService",autowire=Autowire.BY_NAME)
	public DetailsService getDetailsService(){
		DetailsServiceImpl ds=new DetailsServiceImpl();
		ds.setHdr(getHibernateDeatilsRepository());
		return ds;
	}
	
	@Bean(name="detailsRepository")
	public HibernateDeatilsRepository getHibernateDeatilsRepository(){
		return new HibernateDeatilsRepositoryImpl();
	}

}
