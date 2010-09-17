package org.springapp.controller;

/*
 * 	This is a simple example of a form controller. 
 * Currently it maps HelloForm.ftl for GET requests. It basically outputs a default
 * HelloForm object to which the form data is bound.
 * If the user edits this data then hits submit, then for the POST method, PostHelloForm.ftl is
 * the corresponding view.
 * 	
 * 	Still would like to figure out how extend existing spring controllers like SimpleFormController
 * for working with forms.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloFormController {
		
	// Yet another simple GetHello.ftl page that sends the HTTP GET request 
	// This view just displays a form with some default values
	@RequestMapping( value="/HelloForm",method=RequestMethod.GET)
	@ModelAttribute("helloForm")
	public HelloForm GetHello(Model model){
		HelloForm hello = new HelloForm("Jasmine", "Sandhu", 1, false);
		return hello;
	}
	
	// Yet another simple GetHello.ftl page that sends the HTTP GET request 
	// This view just displays a form with some default values
	@RequestMapping( value="/PostHelloForm", method=RequestMethod.POST)
	public ModelAndView PostHello(@ModelAttribute HelloForm helloForm, BindingResult result) {
		
		if( result.hasErrors()) {
			System.out.println("BindingResult has errors!");
		} else {
			System.out.println("No BindingResult errors!");
		}
		
		/* TESTING
		System.out.println("First Name:" + helloForm.getFirstname() +
				"Last Name:" + helloForm.getLastname() +
				"ID:" + helloForm.getId());
		*/
		ModelAndView mav = new ModelAndView("PostHelloForm");
		mav.addObject("userInputs", helloForm);
		
		return mav;
	}
}