package com.example.desk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {

	
	 @GetMapping("/user/home")
	    public String UserHomePage() {
	        return "Userhomepage";
	    }
}