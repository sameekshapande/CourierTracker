package com.courierTrackerService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.StoreAgentDetails;

import CourierTrackerException.exception.CourierTrackerException;

public interface CourierTrackerRepository extends JpaRepository<CourierOrderDetails, Long> 
{
	CourierOrderDetails findByOrderId(Long orderId) throws CourierTrackerException;
	
	List<CourierOrderDetails> findByStoreAgentDetails(StoreAgentDetails storeAgentDetails);
}
