package com.courierTrackerService.service;

import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;

import CourierTrackerException.exception.CourierTrackerException;

public interface StoreAgentService {

	public StoreAgentDetails createStoreAgents(StoreAgentDetails storeAgentDetails) throws CourierTrackerException;

	public ResponseStatus removeStoreAgents(Long storeAgentDetailsId)  throws CourierTrackerException;

	public StoreAgentDetails updateStoreAgents(StoreAgentDetails storeAgentDetails) throws CourierTrackerException;

	public StoreAgentDetails getStoreAgentDetails(String name) throws CourierTrackerException;

}
