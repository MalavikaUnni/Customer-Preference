package com.cts.superstore.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.superstore.repository.GetCustomerIdRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetCustomerByIdServiceTest {

	@InjectMocks
	GetCustomerIdServiceImplementation getCustomerByIdService;
	
	@Mock
	GetCustomerIdRepository getCustomerIdRepo;
	
	//public void findByCustId{
		
	//}

}
