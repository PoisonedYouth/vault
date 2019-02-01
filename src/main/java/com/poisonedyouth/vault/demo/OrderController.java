package com.poisonedyouth.vault.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private OrderRepository repository;

	@Autowired
	public OrderController(OrderRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		return new ResponseEntity<>(repository.save(order), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Order>> getAllOrders() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAllOrders() {
		repository.deleteAll();
	}

	@RequestMapping(value = "/{productName}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Order>> getOrderByProductName(@PathVariable String productName) {
		return new ResponseEntity<>(repository.findByProductName(productName), HttpStatus.OK);
	}
}
