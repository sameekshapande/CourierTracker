package com.courierTrackerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courierTrackerService.model.Constant;
import com.courierTrackerService.model.CourierOrderDetails;
import com.courierTrackerService.model.CourierOrderResponse;
import com.courierTrackerService.model.CourierPkgWeightCharge;
import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.model.UpdateCourierOrderStatusRequest;
import com.courierTrackerService.repo.CourierPkgWeightChargeRepository;
import com.courierTrackerService.repo.CourierTrackerRepository;
import com.courierTrackerService.transfromer.CourierTrackerServiceTransformer;
import com.courierTrackerService.util.ValidationUtils;

import CourierTrackerException.exception.CourierTrackerException;

@Service
public class CourierTrackerServiceImpl implements CourierTrackerService {
	 @Autowired
	private CourierTrackerRepository  courierTrackerRepository;
	
	 @Autowired
	private CourierPkgWeightChargeRepository  courierPkgWeightChargeRepo;
	 
	 @Autowired
	private ValidationUtils  validationUtils;
	 

		@Autowired
		private LoginService loginService;
	
    @Override
    public CourierOrderResponse bookNow(CourierOrderDetails courierOrderDetails) throws CourierTrackerException
    {
    	CourierOrderDetails courierOrder = null;
    	CourierOrderResponse courierOrderResponse = new CourierOrderResponse();
    	CourierPkgWeightCharge  courierPkgWeightCharge;
        try{
        	courierOrderDetails.setStatus(Constant.INITIATED.toString());        	
        	StoreAgentDetails storeAgentDetails = loginService.getUserLoginDetails(courierOrderDetails.getLoginId());
        	courierOrderDetails.setStoreAgentDetails(storeAgentDetails);        	
        	courierOrder = courierTrackerRepository.save(courierOrderDetails); 
        	courierPkgWeightCharge =  courierPkgWeightChargeRepo.findByWeight(courierOrder.getCourierWeight());
        }catch (Exception ex){
            throw new CourierTrackerException("Internal Server Error please contact admin");
        }
        courierOrderResponse= new CourierOrderResponse.CourierOrderResponseBuilder().
        												orderId(courierOrder.getOrderId()).
        												paymentAmount(courierPkgWeightCharge.getCharge()).build();
        return courierOrderResponse;
    }

    
    @Override
	public CourierPkgWeightCharge courierPackageCharge(CourierPkgWeightCharge courierPkgWeightCharge) throws CourierTrackerException 
    {
		CourierPkgWeightCharge courierPkgWeightChargeDtl = null;
        try{
        	boolean isNotPkgAlreadyConfigured = validationUtils.checkPkgWeightAlreadyConfigured(courierPkgWeightCharge);
        	if(!isNotPkgAlreadyConfigured)
        	{
        	courierPkgWeightChargeDtl = courierPkgWeightChargeRepo.save(courierPkgWeightCharge);
        	}
        	else {
        		throw new CourierTrackerException("Package charges already configured for this weight");
        	}
        }catch (Exception ex){
        	ex.printStackTrace();
            throw new CourierTrackerException("Internal Server Error please contact admin");
        }
        return courierPkgWeightChargeDtl;
    
	}


	@Override
	public CourierOrderDetails orderDetailsByOrderId(Long orderId) throws CourierTrackerException { 
        return courierTrackerRepository.findByOrderId(orderId);
    }


	@Override
	public CourierOrderDetails updateOrderStatus(UpdateCourierOrderStatusRequest updateCourierOrderStatusRequest)
			throws CourierTrackerException {
		CourierOrderDetails courierOrderDetails = null;
		try {
			Long orderId = updateCourierOrderStatusRequest.getOrderId();
			CourierOrderDetails dbCourierOrderDetails = courierTrackerRepository.findByOrderId(orderId);
			courierOrderDetails = courierTrackerRepository.save(CourierTrackerServiceTransformer.transform(dbCourierOrderDetails, updateCourierOrderStatusRequest));
		} catch (Exception ex) {
			throw new CourierTrackerException("Internal Server Error please contact admin");
		}
		if (courierOrderDetails == null) {
			throw new CourierTrackerException("Internal Server Error please contact admin");
		}
		return courierOrderDetails;
		}


	@Override
	public List<CourierOrderDetails> ordersAssignedToDeliveryBoy(StoreAgentDetails storeAgentDetails)
			throws CourierTrackerException {
		return courierTrackerRepository.findByStoreAgentDetails(storeAgentDetails);
	}
 

}