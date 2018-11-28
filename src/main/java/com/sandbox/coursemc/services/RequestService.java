package com.sandbox.coursemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.coursemc.domain.Request;
import com.sandbox.coursemc.repositories.RequestRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;
	
	public Request find(Integer id) throws ObjectNotFoundException {
		Optional<Request> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Request.class.getName()));				
	}
}
