package com.example.desk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.desk.model.UserRegister;
import com.example.desk.repository.UserRepository;







@Controller
public class HomeController {
	

	@Autowired
	private UserRepository userRepo;
		


	@GetMapping("/")
	public String welcome() 
	{
		return "HomePage";
	}
	
	

    @GetMapping("/userLogin")
	    public String userLoginPage() {
	        return "userLogin";
	    }
	
	
	

	    
	 
@GetMapping("/userRegistration")
public String userRegistrationPage(Model model) {
	System.out.println("ggggggg");
  UserRegister userModel = new UserRegister();
   model.addAttribute("userModel", userModel);
   return "userRegister";
}


@PostMapping("/userLogin")
public String saveUsers(UserRegister userModel) 
{
	System.out.println(userModel);
   userRepo.save(userModel);
   return "redirect:/userLog";
}
	
	

	
   

}
	
	

    
    
    

   









