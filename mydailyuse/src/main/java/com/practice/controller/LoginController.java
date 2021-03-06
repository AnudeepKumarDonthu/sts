/**
 * 
 */
package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.practice.model.UserDetails;

/**
 * @author Anudeep Kumar
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/PracticeRoot", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("UserDetails") UserDetails userdetails, ModelAndView modelandview) {
		modelandview.setViewName("PracticeRoot");
		return modelandview;

	}
	@RequestMapping(value = "/userdetails", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("UserDetails") UserDetails userdetails, ModelAndView modelandview) {
		/*System.out.println("userDetails " + userdetails.getUserid());
		System.out.println("Password " + userdetails.getPassword());
		System.out.println("Age " + userdetails.getAge());*/
		modelandview.addObject("userdetails", userdetails);
		modelandview.setViewName("Result");
		return modelandview;

	}

}
