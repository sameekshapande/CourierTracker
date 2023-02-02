package com.courierTrackerService.service;

import com.courierTrackerService.model.StoreAgentDetails;

import CourierTrackerException.exception.CourierTrackerException;

public interface LoginService {

	public StoreAgentDetails getUserLoginDetails(String phoneNum) throws CourierTrackerException;

	public StoreAgentDetails findByBrandAndPrice(String phoneNum, String password) throws CourierTrackerException;

}
