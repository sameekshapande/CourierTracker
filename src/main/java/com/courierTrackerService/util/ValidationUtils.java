package com.courierTrackerService.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.courierTrackerService.model.CourierPkgWeightCharge;
import com.courierTrackerService.repo.CourierPkgWeightChargeRepository;

import CourierTrackerException.exception.CourierTrackerException; 

@Service
public class ValidationUtils {
	@Autowired
	private CourierPkgWeightChargeRepository courierPkgWeightChargeRepo;

	@GetMapping(value = "/searchRates", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean checkPkgWeightAlreadyConfigured(CourierPkgWeightCharge courierPkgWeightCharge)
			throws CourierTrackerException {
		try {
		Iterable<CourierPkgWeightCharge> courierPkgWight = courierPkgWeightChargeRepo.findAll();
		List<CourierPkgWeightCharge> courierPkgWightList = StreamSupport.stream(courierPkgWight.spliterator(), false)
				.collect(Collectors.toList());
		return courierPkgWightList.stream().anyMatch(i -> Objects.equals(i.getWeight(), courierPkgWeightCharge.getWeight()));
		}
		catch (Exception e)
		{
			throw new CourierTrackerException("Check checkPkgWeightAlreadyConfigured "+e);
		}
	}

}
