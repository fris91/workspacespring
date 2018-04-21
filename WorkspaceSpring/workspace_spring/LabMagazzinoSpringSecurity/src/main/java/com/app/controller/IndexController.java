//package com.app.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class IndexController {
//	
//	@RequestMapping(value="/god/index", method=RequestMethod.GET)
//	public String indexGod(HttpServletRequest request, ModelMap model) {
//		return "god/index";
//	}
//	
//	@RequestMapping(value="/admin/index", method=RequestMethod.GET)
//	public String indexAdmin(HttpServletRequest request, ModelMap model) {
//		return "admin/index";
//	}
//	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String index(HttpServletRequest request, ModelMap model) {
//		return "indexUser";
//	}
//
//}