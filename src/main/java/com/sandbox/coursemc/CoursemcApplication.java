package com.sandbox.coursemc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.coursemc.domain.Category;
import com.sandbox.coursemc.domain.City;
import com.sandbox.coursemc.domain.Product;
import com.sandbox.coursemc.domain.State;
import com.sandbox.coursemc.repositories.CategoryRepository;
import com.sandbox.coursemc.repositories.CityRepository;
import com.sandbox.coursemc.repositories.ProductRepository;
import com.sandbox.coursemc.repositories.StateRepository;

@SpringBootApplication
public class CoursemcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoriaRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoursemcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		State st1 = new State(null, "Santa Catarina");
		State st2 = new State(null, "Paraná");
		
		City c1 = new City(null, "Joinville", st1);
		City c2 = new City(null, "Florianpolis", st1);
		City c3 = new City(null, "Curitiba", st2);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));		
		
		
	}
}
