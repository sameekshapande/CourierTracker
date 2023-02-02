package com.courierTrackerService.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.CourierOrderResponse;
import com.courierTrackerService.model.CourierPkgWeightCharge;
import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.model.UpdateCourierOrderStatusRequest;

import CourierTrackerException.exception.CourierTrackerException;

public interface CourierTrackerService {	

	public CourierOrderResponse bookNow(CourierOrderDetails courierOrderDetails) throws CourierTrackerException;

	public CourierPkgWeightCharge courierPackageCharge(CourierPkgWeightCharge courierPkgWeightCharge)
			throws CourierTrackerException;

	public CourierOrderDetails orderDetailsByOrderId(Long orderId) throws CourierTrackerException;

	public CourierOrderDetails updateOrderStatus(UpdateCourierOrderStatusRequest updateCourierOrderStatusRequest) throws CourierTrackerException;

	public  List<CourierOrderDetails> ordersAssignedToDeliveryBoy(StoreAgentDetails storeAgentDetails)  throws CourierTrackerException;


}
