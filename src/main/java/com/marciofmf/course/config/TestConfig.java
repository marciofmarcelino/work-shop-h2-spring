package com.marciofmf.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marciofmf.course.entities.Category;
import com.marciofmf.course.entities.Order;
import com.marciofmf.course.entities.OrderItem;
import com.marciofmf.course.entities.Payment;
import com.marciofmf.course.entities.Product;
import com.marciofmf.course.entities.User;
import com.marciofmf.course.entities.enums.OrderStatus;
import com.marciofmf.course.repositories.CategoryRepository;
import com.marciofmf.course.repositories.OrderItemRepository;
import com.marciofmf.course.repositories.OrderRepository;
import com.marciofmf.course.repositories.ProductRepository;
import com.marciofmf.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
	
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u = new User(null, "Maria", "maria@gmail.com", "9999999999", "12345");
		User u2 = new User(null, "Jose", "josemaria@gmail.com", "9999999999", "12345");
		
		userRepository.saveAll(Arrays.asList(u,u2));
		
		Order o1 = new Order(null, Instant.parse("2019-03-15T19:53:07Z"),OrderStatus.PAID,u);
		Order o2 = new Order(null, Instant.parse("2022-08-20T20:10:33Z"),OrderStatus.WAITING_PAYMENT,u);
		Order o3 = new Order(null, Instant.parse("2020-06-20T13:40:44Z"),OrderStatus.SHIPPED,u);
		
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-03-15T21:53:07Z"),o1);
		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
	
	
	
}
