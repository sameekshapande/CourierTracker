package com.courierTrackerService.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.courierTrackerService.model.StoreAgentDetails;

import CourierTrackerException.exception.CourierTrackerException;

public interface LoginService {

	public StoreAgentDetails getUserLoginDetails(String phoneNum) throws CourierTrackerException;

	public StoreAgentDetails findByBrandAndPrice(String phoneNum, String password) throws CourierTrackerException;

	public String resetPassword(String email) throws
	  CourierTrackerException, AddressException, MessagingException;

}
