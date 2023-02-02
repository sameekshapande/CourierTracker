package com.courierTrackerService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class CourierPkgWeightCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
	private Long weight;
	private Long charge;

}
