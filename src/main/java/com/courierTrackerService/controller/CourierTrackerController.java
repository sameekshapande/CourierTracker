package com.courierTrackerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.CourierOrderResponse;
import com.courierTrackerService.model.CourierPkgWeightCharge;
import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.model.UpdateCourierOrderStatusRequest;
import com.courierTrackerService.repo.CourierTrackerRepository;
import com.courierTrackerService.service.CourierTrackerService;

import CourierTrackerException.exception.CourierTrackerException; 

@RestController
@RequestMapping("/courierTracker")
public class CourierTrackerController {

	@Autowired
	private CourierTrackerService courierTrackerService;

	@Autowired
	private CourierTrackerRepository courierTrackerRepository;

	@PostMapping(value = "/bookNow", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourierOrderResponse> bookNow(@RequestBody CourierOrderDetails courierOrderDetails)
			throws CourierTrackerException {
		return new ResponseEntity<>(courierTrackerService.bookNow(courierOrderDetails), HttpStatus.OK);
	}// used by  admin

	@PostMapping(value = "/courierPackageCharge", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourierPkgWeightCharge> courierPackageCharge(
			@RequestBody CourierPkgWeightCharge courierPkgWeightCharge) throws CourierTrackerException {
		return new ResponseEntity<>(courierTrackerService.courierPackageCharge(courierPkgWeightCharge), HttpStatus.OK);
	}// used by admin
 
	@RequestMapping(value = "/orderDetailsByOrderId/{id}")
	public  CourierOrderDetails  orderDetailsByOrderId(@PathVariable Long id)
			throws CourierTrackerException {
		CourierOrderDetails courierOrderDetails = courierTrackerService.orderDetailsByOrderId(id);
		return courierOrderDetails;
	}// used by admin 
	
	@PostMapping(value = "/updateOrderStatus", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStatus> updateOrderStatus(
			@RequestBody UpdateCourierOrderStatusRequest updateCourierOrderStatusRequest)
			throws CourierTrackerException {
		courierTrackerService.updateOrderStatus(updateCourierOrderStatusRequest);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	// used by delivery role

	@GetMapping(value = "/getAllOrderPkgId", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CourierOrderDetails>> getAllOrderPkgId() throws CourierTrackerException {
		return new ResponseEntity<>(courierTrackerRepository.findAll(), HttpStatus.OK);
	}// used by admin
	
	@RequestMapping(value = "/ordersAssignedToDeliveryBoy")
	public   List<CourierOrderDetails>   ordersAssignedToDeliveryBoy( @RequestBody StoreAgentDetails storeAgentDetails)
			throws CourierTrackerException {
		 List<CourierOrderDetails>  courierOrderDetails = courierTrackerService.ordersAssignedToDeliveryBoy(storeAgentDetails);
		return courierOrderDetails;
	}// used by delivery 
	
 

	@GetMapping("/home")
	public String home() {
		return "home";
	}

}