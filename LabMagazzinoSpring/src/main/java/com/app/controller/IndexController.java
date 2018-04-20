package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) { //ModelMap permette di passare attributi alla request
		return "index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String backIndex(HttpServletRequest request, ModelMap model) { //ModelMap permette di passare attributi alla request
		return "index";
	}
}