package com.sandbox.coursemc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sandbox.coursemc.domain.Address;
import com.sandbox.coursemc.domain.Category;
import com.sandbox.coursemc.domain.City;
import com.sandbox.coursemc.domain.Customer;
import com.sandbox.coursemc.domain.Payment;
import com.sandbox.coursemc.domain.PaymentWithCredicard;
import com.sandbox.coursemc.domain.PaymentWithTicket;
import com.sandbox.coursemc.domain.Product;
import com.sandbox.coursemc.domain.Request;
import com.sandbox.coursemc.domain.State;
import com.sandbox.coursemc.domain.enums.CustomerType;
import com.sandbox.coursemc.domain.enums.PaymentStatus;
import com.sandbox.coursemc.repositories.AddressRepository;
import com.sandbox.coursemc.repositories.CategoryRepository;
import com.sandbox.coursemc.repositories.CityRepository;
import com.sandbox.coursemc.repositories.CustomerRepository;
import com.sandbox.coursemc.repositories.PaymentRepository;
import com.sandbox.coursemc.repositories.ProductRepository;
import com.sandbox.coursemc.repositories.RequestRepository;
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
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	

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
		
		Customer cust1 = new Customer(null, "Vitor Mendes", "vitormendes@gmail.com", "00930293929", CustomerType.NATURALPERSON);		
		
		cust1.getTelephones().addAll(Arrays.asList("12345555","4334343"));
		
		Address add1 = new Address(null, "Rua Colon", "421", "AP 502 BL A", "Gloria", "89777-789", cust1, c1);
		Address add2 = new Address(null, "Rua Picolli", "103", "", "Costa e Silva", "89777-789", cust1, c1);
		
		cust1.getAddresses().addAll(Arrays.asList(add1,add2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		customerRepository.saveAll(Arrays.asList(cust1));
		addressRepository.saveAll(Arrays.asList(add1, add2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Request ord1 = new Request(null, sdf.parse("30/09/2018 10:32"), cust1, add1);
		Request ord2 = new Request(null, sdf.parse("30/09/2018 10:32"), cust1, add2);
		
		Payment pay1 = new PaymentWithCredicard(null, PaymentStatus.QUITADO, ord1, 6);
		ord1.setPayment(pay1);
		
		Payment pay2 = new PaymentWithTicket(null, PaymentStatus.PENDENTE, ord2, sdf.parse("01/10/2018 08:00"), null);
		ord2.setPayment(pay2);
		
		cust1.getRequests().addAll(Arrays.asList(ord1, ord2));
		
		requestRepository.saveAll(Arrays.asList(ord1, ord2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
	}
}
