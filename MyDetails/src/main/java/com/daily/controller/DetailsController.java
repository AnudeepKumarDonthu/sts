/**
 * 
 */
package com.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daily.model.Details;

/**
 * @author Anudeep Kumar
 *
 */
@Controller
public class DetailsController {
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("UserDetails") Details userdetails, ModelAndView modelandview) {
		modelandview.setViewName("Home");
		return modelandview;

	}
	
	@RequestMapping(value="/userdetails",method=RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("UserDetails") Details userData,ModelAndView modelandview){
		System.out.println(userData.getUserid());
		System.out.println(userData.getPassword());
		System.out.println(userData.getAge());
		modelandview.setViewName("LoginHome");
		return modelandview;
		
		
		
	}
}
