package com.sandbox.coursemc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.coursemc.domain.Customer;
import com.sandbox.coursemc.services.CustomerService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value="/customers")
public class CustomerResource {

	@Autowired	
	private CustomerService service;
		
	@RequestMapping(value="/{id}", method=RequestMethod.GET)	
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException  {
		Customer obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
}
