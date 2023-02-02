package com.courierTrackerService.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.service.LoginService;

import CourierTrackerException.exception.CourierTrackerException;

@RestController
@RequestMapping("/login")
public class LoginController {
	

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/loginDetail/{phoneNum}")
	public  StoreAgentDetails  getUserLoginDetails(@PathVariable String phoneNum)
			throws CourierTrackerException {
		StoreAgentDetails storeAgentDetails = loginService.getUserLoginDetails(phoneNum);
		return storeAgentDetails;
	}
	
	@GetMapping("/loginDetail")
	public StoreAgentDetails getUserLogin(@RequestParam String phoneNum, 
				@RequestParam String password) throws CourierTrackerException {
		return loginService.findByBrandAndPrice(phoneNum, password);
	}
    
    @RequestMapping(value = "/resetPassword")
    public ResponseStatus resetPassword(@RequestParam String email) throws CourierTrackerException{
    	try {
			String msg = loginService.resetPassword(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
