package com.cts.superstore.controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cts.superstore.controller.GetCustomerByIdController;
import com.cts.superstore.model.Customer;
import com.cts.superstore.service.GetCustomerIdServiceImplementation;
import com.cts.superstore.validator.GetCustomerIdValidator;
@RunWith(SpringJUnit4ClassRunner.class)
public class GetCustomerByIdControllerTest extends Exception {
	@InjectMocks
	private GetCustomerByIdController getCustomerByIdcontroller;
	@Mock
	private GetCustomerIdServiceImplementation getCustomerByIdservice;
	@Mock
	private GetCustomerIdValidator getCustomerByIdvalidator;

	@Test
	public void getCustomerByIdTest() {
		Customer customer=new Customer(102,1212,"ram",9874569874L,"ram@gmail.com","phone","bbbb","hno9","home",null,false,false);
		when(getCustomerByIdservice.findByCustId(1234)).thenReturn(customer);
		boolean valid=getCustomerByIdvalidator.validate(customer);
		if(valid) {
		Customer result=(Customer) getCustomerByIdcontroller.getCustomerByCustId(1234).getBody();
		assertEquals(customer.getName(), result.getName());
		verify(getCustomerByIdservice,times(1)).findByCustId(1234);
		}
	}
	
	@Test(expected=NoSuchElementException.class)
	public void getCustomerByIdExceptionTest() throws Exception{
		
		//Exception exception=assertThrows(NoSuchElementException.class, () -> {
			when(getCustomerByIdservice.findByCustId(1441)).thenThrow(NoSuchElementException.class);
			getCustomerByIdcontroller.getCustomerByCustId(1441); 
		//});
		
		//assertNotNull(exception);
		assertNotNull(NoSuchElementException.class);
		//assertEquals("NO SUCH ELEMENT", exception.getMessage());
		verify(getCustomerByIdservice,times(1)).findByCustId(1441);
	}
}

