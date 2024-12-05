package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Order;
import com.example.demo.Models.OrderItems;
import com.example.demo.Models.Produce;
import com.example.demo.Models.SellerProduce;
import com.example.demo.Models.User;
import com.example.demo.Models.UserType;
import com.example.demo.Repos.OrderItemsRepository;
import com.example.demo.Repos.OrderRepository;
import com.example.demo.Repos.ProduceRepository;
import com.example.demo.Repos.SellerProduceRepository;
import com.example.demo.Repos.UserRepository;



@Component
public class DatabaseInit implements CommandLineRunner
{
	@Autowired 
	private UserRepository userRepository;

	@Autowired
    private ProduceRepository produceRepository;

    @Autowired
    private SellerProduceRepository sellerProduceRepository;

	@Autowired
    private OrderRepository orderRepository;

	@Autowired
    private OrderItemsRepository orderItemsRepository;
	
	
	@Override
	 public void run(String... args) throws Exception 
	 {
		userRepository.deleteAll();
		produceRepository.deleteAll();
		sellerProduceRepository.deleteAll();
		orderRepository.deleteAll();
		
		
		User bob = new User("Bob","bob@sample.com", "bob_pass", UserType.BUYER);
		User alice = new User("Alice", "alice@sample.com", "alice_pass", UserType.SELLER);
		User carol = new User("Carol", "carol@sample.com", "carol_pass", UserType.BOTH);
		User altti = new User("Altti", "altti@sample.com", "altti_pass", UserType.BUYER);
		userRepository.save(bob);
		userRepository.save(alice);
		userRepository.save(carol);
		userRepository.save(altti);

		Produce apple = new Produce("Apple");
		Produce lettuce = new Produce("Lettuce");
		Produce potato = new Produce("Potato");
		produceRepository.save(apple);
		produceRepository.save(lettuce);
		produceRepository.save(potato);
		
		SellerProduce aliceApple = new SellerProduce(alice, apple, 100, 0.15f);
		SellerProduce aliceLettuce = new SellerProduce(alice, lettuce, 20, 0.25f);
		SellerProduce carolApple = new SellerProduce(carol, apple, 50, 0.30f);
		SellerProduce carolPotato = new SellerProduce(carol, potato, 30, 0.05f);
		sellerProduceRepository.save(aliceApple);
		sellerProduceRepository.save(aliceLettuce);
		sellerProduceRepository.save(carolApple);
		sellerProduceRepository.save(carolPotato);

		Order bobOrder = new Order(bob);
		orderRepository.save(bobOrder);

		OrderItems bobOrderItemsApple = new OrderItems(bobOrder, carolApple, 2, 0.30f);
		OrderItems bobOrderItemsLettuce = new OrderItems(bobOrder, aliceLettuce, 1, 0.25f);
		orderItemsRepository.save(bobOrderItemsApple);
		orderItemsRepository.save(bobOrderItemsLettuce);

		Order alttiOrder = new Order(altti);
		orderRepository.save(alttiOrder);

		OrderItems alttiOrderItemsApple = new OrderItems(alttiOrder, aliceApple, 10, 0.15f);
		OrderItems alttiOrderItemsLettuce = new OrderItems(alttiOrder, carolPotato, 15, 0.05f);
		orderItemsRepository.save(alttiOrderItemsApple);
		orderItemsRepository.save(alttiOrderItemsLettuce);


		System.out.println("Database initialization complete!");
	}
}
