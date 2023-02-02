package com.courierTrackerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.courierTrackerService.model.StoreAgentDetails;
import com.courierTrackerService.repo.StoreAgentRepository;
import com.courierTrackerService.util.Utils;

import CourierTrackerException.exception.CourierTrackerException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private StoreAgentRepository storeAgentRepository;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Utils utils;

	@Override
	public StoreAgentDetails getUserLoginDetails(String phoneNum) throws CourierTrackerException {

		return storeAgentRepository.findByPhonenumber(phoneNum);
	}

	@Override
	public StoreAgentDetails findByBrandAndPrice(String phoneNum, String password) throws CourierTrackerException {

		return storeAgentRepository.findByPhonenumberAndPassword(phoneNum, password);
	}

	@Override
	public String resetPassword(String email) throws CourierTrackerException {
		char[] tempPassword=utils.generatePassword(6);
		sendSimpleEmail(email, "Your Temporary password is "+tempPassword+". Please go to below URL to reset the password.", 
				"Reset the Password for Courier Tracker Application");
		StoreAgentDetails storeAgent = storeAgentRepository.findByEmail(email);
		storeAgent.setTempPassword(tempPassword.toString());
		storeAgentRepository.save(storeAgent);

		return "Mail Sent Successfully";

	}

	public void sendSimpleEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sameekshapande@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail Send...");

	}

}
