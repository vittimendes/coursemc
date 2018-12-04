package com.sandbox.coursemc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.coursemc.domain.Category;
import com.sandbox.coursemc.repositories.CategoryRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) throws ObjectNotFoundException {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));				
	}
	
	public Category insert (Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Category update (Category obj) {
		//find(obj.getId());		
		return repo.save(obj);
	}
}
