package com.courierTrackerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.repo.StoreAgentRepository;

import CourierTrackerException.exception.CourierTrackerException;

@Service
public class LoginServiceImpl  implements LoginService {
	
	 @Autowired
		private StoreAgentRepository  storeAgentRepository;

	@Override
	public StoreAgentDetails getUserLoginDetails(String phoneNum) throws CourierTrackerException {
		
		return storeAgentRepository.findByPhonenumber(phoneNum);
	}

	@Override
	public StoreAgentDetails findByBrandAndPrice(String phoneNum, String password) throws CourierTrackerException {
		 
		return storeAgentRepository.findByPhonenumberAndPassword(phoneNum, password);
	}

}
