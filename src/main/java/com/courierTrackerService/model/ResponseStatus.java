package com.courierTrackerService.model;

import java.util.List;

public class ResponseStatus {
private String status;
private String responseMessage;
private List<CourierOrderDetails> courierOrderDetailsList ;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
public List<CourierOrderDetails> getCourierOrderDetailsList() {
	return courierOrderDetailsList;
}
public void setCourierOrderDetailsList(List<CourierOrderDetails> courierOrderDetailsList) {
	this.courierOrderDetailsList = courierOrderDetailsList;
}
 

}
