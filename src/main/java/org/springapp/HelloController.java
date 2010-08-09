package org.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Controller
public class HelloController {

	@RequestMapping("/hello.ftl")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // FIXME: use logging
        System.out.println("Returning hello view");

        return new ModelAndView("hello");   // no Map associated with ModelAndView
    }
}
