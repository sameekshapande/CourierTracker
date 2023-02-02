package com.courierTrackerService.repo;

import org.springframework.data.repository.CrudRepository;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.CourierPkgWeightCharge;

import CourierTrackerException.exception.CourierTrackerException;

public interface CourierPkgWeightChargeRepository extends CrudRepository<CourierPkgWeightCharge, Long> 
{
	CourierPkgWeightCharge findByWeight(Long weight) throws CourierTrackerException;
}
