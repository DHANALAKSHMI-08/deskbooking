package com.example.desk.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desk.model.UserRegister;
import com.example.desk.repository.UserRepository;






@Service
public class UserLoginService 
{
	
	  @Autowired private UserRepository userRepository;
	  
	 public boolean userLogin(UserRegister userRegister) 
	 { 
		 UserRegister userReg =userRepository.findByUsername(userRegister.getUsername()); 
		 if(userReg != null && userReg.getPassword().equals(userRegister.getPassword()))
		 {
			 return true;
			 }
		 
	  else { 
		  return false; 
		  } 
	  }
}
	  

