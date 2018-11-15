package com.sandbox.coursemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.coursemc.domain.Customer;
import com.sandbox.coursemc.repositories.CustomerRepository;

import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer find(Integer id) throws ObjectNotFoundException{
		Optional<Customer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
	}
	
}
