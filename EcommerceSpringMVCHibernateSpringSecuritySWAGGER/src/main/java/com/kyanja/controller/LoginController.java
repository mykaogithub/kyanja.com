package com.kyanja.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	public LoginController() {
		System.out.println("LoginController()");
	}	
	
	
@RequestMapping("/login")
public String login(){
	System.out.println("LoginController()  called");
return "login";
}


@RequestMapping("/logout")
public String logout(){
	
	System.out.println("Logout  called");
return "logout";
}

@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
public String loginerror(ModelMap model) {
    model.addAttribute("error", "true");
    return "denied";
}
}