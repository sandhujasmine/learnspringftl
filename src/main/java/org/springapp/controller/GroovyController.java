package org.springapp.controller;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.api.Talker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Demonstrate execution of Groovy code from a Java Web application.
 * <p>
 * This is mainly a prototype for running Groovy-based plugins from Mifos.
 */
@Controller
@RequestMapping("/groovy")
public class GroovyController {
	public static final String HOMEDIR = System.getProperty("user.home");

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("groovy");
		ClassLoader parent = getClass().getClassLoader();
		GroovyClassLoader loader = new GroovyClassLoader(parent);
		Class groovyClass = loader.parseClass(new File(HOMEDIR + "/.mifos/groovy/helloWorld.groovy"));
		Talker talker = (Talker) groovyClass.newInstance();
		System.out.println(talker.sayHi());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView("groovy");
		return modelAndView;
	}
}
