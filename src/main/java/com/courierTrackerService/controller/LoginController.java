package com.courierTrackerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
