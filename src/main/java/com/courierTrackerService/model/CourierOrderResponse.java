package com.courierTrackerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierOrderResponse {
	private Long orderId;
	private Long paymentAmount;
	
	private CourierOrderResponse(CourierOrderResponseBuilder builder) {
		this.orderId = builder.orderId;
		this.paymentAmount = builder.paymentAmount;
	}
	
	public static class CourierOrderResponseBuilder
	{
		private  Long orderId;
		private  Long paymentAmount;

 
		public CourierOrderResponseBuilder orderId(Long orderId) {
			this.orderId = orderId;
			return this;
		}
		public CourierOrderResponseBuilder paymentAmount(Long paymentAmount) {
			this.paymentAmount = paymentAmount;
			return this;
		}
		 
		//Return the finally consrcuted User object
		public CourierOrderResponse build() {
			CourierOrderResponse user =  new CourierOrderResponse(this);
			validateUserObject(user);
			return user;
		}
		private void validateUserObject(CourierOrderResponse user) {
			//Do some basic validations to check
			//if user object does not break any assumption of system
		}
	}
}
