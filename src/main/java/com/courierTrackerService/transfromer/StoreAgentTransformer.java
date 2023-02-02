package com.courierTrackerService.transfromer;

import org.springframework.stereotype.Component;

import com.courierTrackerService.model.StoreAgentDetails;

@Component
public class StoreAgentTransformer {

    public static StoreAgentDetails transform(StoreAgentDetails dbStoreAgentDetails, StoreAgentDetails storeAgentDetails){
    	 if(storeAgentDetails.getName() != null){
         	dbStoreAgentDetails.setName(storeAgentDetails.getName());
         }
         if(storeAgentDetails.getPhonenumber() != null){
         	dbStoreAgentDetails.setPhonenumber(storeAgentDetails.getPhonenumber());
         }
         if(storeAgentDetails.getEmail() != null){
          	dbStoreAgentDetails.setEmail(storeAgentDetails.getEmail());
          }
         if(storeAgentDetails.getRole() != null){
           	dbStoreAgentDetails.setRole(storeAgentDetails.getRole());
           } 
    	
        return dbStoreAgentDetails;
    }



}
