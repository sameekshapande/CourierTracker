package com.courierTrackerService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourierOrderDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId ;
    private String customerName;
    private String customerphoneNumber;
	private String recieverName;
	private String recieverAddress;
	private String customerAddress;
	private Long courierWeight;
	private String receiverphoneNumber;
	private String courierDetailComment;
	@ColumnDefault("false")
	private boolean handleWithCare;
	private String status; 
	private String loginId;
    @ManyToOne
    @JoinColumn(name ="USER_ID")
    private StoreAgentDetails storeAgentDetails;
	
	
}
