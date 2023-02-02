package com.courierTrackerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourierOrderRequest {
	private String customerName;
	private String recieverName;
	private String recieverAddress;
	private String customerAddress;
	private String courierWeight;
	private String receiverphoneNumber;

}
