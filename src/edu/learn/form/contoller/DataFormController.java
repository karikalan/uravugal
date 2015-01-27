package edu.learn.form.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.learn.form.vo.UserDataVO;


public class DataFormController {
	
	@RequestMapping(method =  RequestMethod.GET)
	public String initModel( ModelMap model){
		UserDataVO defaultUser = new UserDataVO();
		defaultUser.setUserName("Athirathan");
		defaultUser.setAddress("Anga desam");
		defaultUser.setPassword("karnan");
		defaultUser.setConfirmPassword("karnan");
		
		model.addAttribute("defaultuser", defaultUser);
		
		return "dataForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(){
		return null;
	}

}
