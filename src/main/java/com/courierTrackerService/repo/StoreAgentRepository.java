package com.courierTrackerService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courierTrackerService.model.StoreAgentDetails;

import CourierTrackerException.exception.CourierTrackerException;

public interface StoreAgentRepository extends JpaRepository<StoreAgentDetails, Long> {

	StoreAgentDetails findByName(String name) throws CourierTrackerException;
	
	StoreAgentDetails findByPhonenumber(String phoneNum) throws CourierTrackerException;
	
	StoreAgentDetails findByPhonenumberAndPassword(String phoneNum,String password) 
			throws CourierTrackerException;
	StoreAgentDetails findByEmail(String email) throws CourierTrackerException;
}
