package com.courierTrackerService.transfromer;

import org.springframework.stereotype.Component;

import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.UpdateCourierOrderStatusRequest;
 

@Component
public class CourierTrackerServiceTransformer {

    public static CourierOrderDetails transform(CourierOrderDetails dbCourierOrderDetails, UpdateCourierOrderStatusRequest courierOrderDetailsToUpdate){
        if(courierOrderDetailsToUpdate.getOrderId() != null){
        	dbCourierOrderDetails.setOrderId(courierOrderDetailsToUpdate.getOrderId());
        }
        if(courierOrderDetailsToUpdate.getStatus() != null){
        	dbCourierOrderDetails.setStatus(courierOrderDetailsToUpdate.getStatus());
        } 
        return dbCourierOrderDetails;
    }

}
