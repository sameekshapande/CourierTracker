package com.courierTrackerService.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.service.StoreAgentService;
import org.json.JSONObject;

import CourierTrackerException.exception.CourierTrackerException; 

@RestController
@RequestMapping("/storeAgent")
public class StoreAgentController {

	@Autowired
	private StoreAgentService storeAgentService;
	
	  @PostMapping(value = "/createStoreAgents", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<StoreAgentDetails> createStoreAgents(@RequestBody StoreAgentDetails storeAgentDetails) throws CourierTrackerException {
	        return new ResponseEntity<StoreAgentDetails>(storeAgentService.createStoreAgents(storeAgentDetails), HttpStatus.OK);
	    }
	  
	   @PostMapping(value = "/removeStoreAgents", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ResponseStatus> removeStoreAgents(@RequestBody StoreAgentDetails storeAgentDetails) throws CourierTrackerException  {
	        Long storeAgentDetailsId =  storeAgentDetails.getId();
	        return new ResponseEntity<ResponseStatus>(storeAgentService.removeStoreAgents(storeAgentDetailsId), HttpStatus.OK);
	    }
	   
	    @PostMapping(value = "/updateStoreAgents", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<JSONObject> updateStoreAgents(@RequestBody StoreAgentDetails storeAgentDetails) throws CourierTrackerException {
	    	storeAgentService.updateStoreAgents(storeAgentDetails);
	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
	     
	    @RequestMapping(value = "/getStoreAgentDetails/{name}")
	    public StoreAgentDetails getStoreAgentDetails(@PathVariable String name) throws CourierTrackerException {
	    	StoreAgentDetails storeAgentDetails = storeAgentService.getStoreAgentDetails(name);
			return storeAgentDetails;
	    }
 

}
