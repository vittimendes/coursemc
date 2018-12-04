package com.sandbox.coursemc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.coursemc.domain.Request;
import com.sandbox.coursemc.services.RequestService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/requests")
public class RequestResource {
	
	@Autowired
	private RequestService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Request> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Request obj = service.find(id);		
		return ResponseEntity.ok(obj);
		
	}

}
