package com.wagner.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wagner.demo.entities.Category;
import com.wagner.demo.entities.Order;
import com.wagner.demo.entities.OrderItem;
import com.wagner.demo.entities.Payment;
import com.wagner.demo.entities.Product;
import com.wagner.demo.entities.User;
import com.wagner.demo.entities.enums.OrderStatus;
import com.wagner.demo.repositories.CategoryRepository;
import com.wagner.demo.repositories.OrderItemRepository;
import com.wagner.demo.repositories.OrderRepository;
import com.wagner.demo.repositories.ProductRepository;
import com.wagner.demo.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productyRepository;
	
	@Autowired
	OrderItemRepository orderReposistory;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Wagner", "wagner@gmail.com", "54996366433", "123456");
		User user2 = new User(null, "Tanise", "tanise@gmail.com", "54999775753", "123456");
		
		Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), user1, OrderStatus.PAGO);
		Order order2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), user2, OrderStatus.AGUARDANDO_PAGAMENTO);
		Order order3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), user1, OrderStatus.ENTREGUE);
		
		
		Category cat1 = new Category(null, "Computadores");
		Category cat2 = new Category(null, "Notebooks");
		Category cat3 = new Category(null, "Celulares");
		
		Product p1 = new Product(null, "Galaxy S21", "Tela de 6 polegadas, 8GB de RAM", 3955.5, "");
		Product p2 = new Product(null, "Acer Nitro 5", "16GB de ram TRX 2060", 6190.0, "");
		Product p3 = new Product(null, "Moto G20", "3GB de RAM 64GB interno", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Kit completo", 5200.0, "");
		Product p5 = new Product(null, "Iphone 13", "1258GB interno Chip A11", 5100.99, "");
		
		usersRepository.saveAll(Arrays.asList(user1, user2));
		
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		productyRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat3);
		
		
		
		
		productyRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(order1, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(order1, p5, 2, p5.getPrice());
		
		orderReposistory.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		Payment pay1 = new Payment(null, Instant.parse("2022-06-20T17:53:07Z"), order1);
		
		order1.setPayment(pay1);
		
		orderRepository.save(order1);
	}
	
	

}
