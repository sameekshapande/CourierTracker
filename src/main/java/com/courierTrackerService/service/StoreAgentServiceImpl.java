package com.courierTrackerService.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courierTrackerService.model.ResponseStatus;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.repo.StoreAgentRepository;
import com.courierTrackerService.transfromer.StoreAgentTransformer;

import CourierTrackerException.exception.CourierTrackerException;

@Service
public class StoreAgentServiceImpl implements StoreAgentService {
	
	 @Autowired
		private StoreAgentRepository  storeAgentRepository;

	@Override
	public StoreAgentDetails createStoreAgents(StoreAgentDetails storeAgentDetails) throws CourierTrackerException {
		StoreAgentDetails StoreAgentDetail = null;
		 try{
			 StoreAgentDetail = storeAgentRepository.save(storeAgentDetails);
	        }catch (Exception ex){
	            throw new CourierTrackerException("Internal Server Error please contact admin");
	        }
	        if(Objects.isNull(StoreAgentDetail)){
	            throw new CourierTrackerException("Internal Server Error please contact admin");
	        }
	        return StoreAgentDetail;	 
	}

  
	
	  @Override
	    public ResponseStatus removeStoreAgents(Long storeAgentDetailsId) throws CourierTrackerException {
	        ResponseStatus response = new ResponseStatus();
	        try{
	        	storeAgentRepository.deleteById(storeAgentDetailsId);
	            response.setStatus("Success");
	            response.setResponseMessage("Record has been deleted successfully");
	        }catch (Exception ex){
	            response.setStatus("Error");
	            response.setResponseMessage("Exception while deleting the record");
	        }
	        return response;
	    }



	@Override
	public StoreAgentDetails updateStoreAgents(StoreAgentDetails storeAgentDetails) throws CourierTrackerException {
		StoreAgentDetails storeAgentDetail = null;
        try{
            Long storeAgentDetailsId = storeAgentDetails.getId();
            StoreAgentDetails dbStoreAgentDetails = storeAgentRepository.findById(storeAgentDetailsId).get();
            storeAgentDetail = storeAgentRepository.save(StoreAgentTransformer.transform(dbStoreAgentDetails,storeAgentDetails));
        }catch (Exception ex){
            throw new CourierTrackerException("Internal Server Error please contact admin");
        }
        if(storeAgentDetail==null){
            throw new CourierTrackerException("Internal Server Error please contact admin");
        }
        return storeAgentDetail;  
		
	}



	@Override
	public StoreAgentDetails getStoreAgentDetails(String name) throws CourierTrackerException {
	     return storeAgentRepository.findByName(name);
		 
	}

}
