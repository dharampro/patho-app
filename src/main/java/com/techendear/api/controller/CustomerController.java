package com.techendear.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techendear.api.domain.Customer;
import com.techendear.api.exception.InvalidRequest;
import com.techendear.api.service.CustomerService;

import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws BadHttpRequest {
		return ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(this.customerService.addCustomer(customer))
				.orElseThrow(() -> new InvalidRequest("Request is not valid")));
	}

	@GetMapping({"/all"})
	public ResponseEntity<List<Customer>> getAllCustomer() throws NotFoundException {
		return ResponseEntity.ok().body(Optional.of(this.customerService.getAllCustomers())
				.orElseThrow(() -> new NotFoundException("Resource not found")));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.customerService.getCustomerById(id)
				.orElseThrow(() -> new NotFoundException("Customer not found")));
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomrtByLastName(@RequestParam("lastName") String lastName) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(Optional.of(this.customerService.getAllCustomerByLastName(lastName)).orElseThrow());
	}

}
