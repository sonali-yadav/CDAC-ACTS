package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao cdao;

}
