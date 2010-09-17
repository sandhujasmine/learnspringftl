package org.springapp.controller;

/*
* A very basic controller to see how to access the different
* objects created within the ModelAndView object -- the display
* is given in hello.ftl
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HelloController {

	@RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		// create a model-and-view using 'welcome’
	    ModelAndView mav = new ModelAndView("hello");				// initialize ModelAndView object with the view "hello"
	    Map<String,Object> model = new HashMap<String, Object>();	// model that will be returned for display
	   
	    String[] mssgsToInput = {"mssg 1","mssg 2","mssg 3","mssg 4"};
	    List<String> mssgs = createList(mssgsToInput);// create a list object to be added to model
	    Map<String, Object> subMap = createMap();	// create a map object added to model
	    
	    // all objects to model
	    model.put("hello", new String("Hello, hello!"));
	    model.put("checkBool", false);
	    model.put("mssgs", mssgs);
	    model.put("info", subMap);
	    
	    // couldn't quite figure out how to add a Date object to model .. or how to call it from within freemarker
	    // Date date = new Date(); don't know how to use this
	    //model.put("date", new Date()); // don't know how to use this yet
	    
	    // finally, add and return this model object to be displayed by hello.ftl
	    mav.addAllObjects( model);
	    
	    return mav;
    }

	private Map<String, Object> createMap() {
		Map<String,Object> subMap = new HashMap<String, Object>();
	    subMap.put("name",new String("Mannat"));
	    subMap.put("age", new Integer(1));
		return subMap;
	}
	
	// just returns a list to be displayed in hello.ftl
	private List<String> createList( String[] items) {
	    List<String> mssgs = new ArrayList<String>();
	    for (int i = 0; i < items.length; i++) {
	    	mssgs.add(items[i]);
	    }
	    
		return mssgs;
	}
}
