package me.didia.monlift.service;

import me.didia.monlift.entities.User;
import me.didia.monlift.helper.HelperFunctions;
import me.didia.monlift.managers.UserManager;

public class Service {
	
	UserManager userManager = UserManager.getInstance();
	InputValidator inputValidator = InputValidator.getInstance();
	/**
	 * Register service 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param phone
	 * @return id user if user are created else exception
	 */
	public long doRegister(String firstname, String lastname, String email,String phone,String password ) 

	{ 
		
		try{
			if(inputValidator.firstnameValidator(firstname) && inputValidator.lastnameValidator(lastname) && inputValidator.emailValidator(email) && inputValidator.phoneValidator(phone))
				long id =userManager.createUser(firstname, lastname, email, phone, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * login service 
	 * 
	 * @param email
	 * @param password
	 * @return token if user found else null
	 */
	public String doLogin(String email, String password){
		String token = null;
		User loggingInUser =null;// UserFactory.getUserByEmailandPassword(email, password);
		if(loggingInUser !=null){
			token = HelperFunctions.generateToken(loggingInUser);
		}
		return token;
	}
	
	public void doLogout(){
		
	}
}
