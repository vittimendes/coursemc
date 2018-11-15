package com.sandbox.coursemc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.coursemc.domain.Category;
import com.sandbox.coursemc.repositories.CategoryRepository;

@SpringBootApplication
public class CoursemcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoursemcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Categoria 1");
		Category cat2 = new Category(null, "Categoria 2");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
	}
}
