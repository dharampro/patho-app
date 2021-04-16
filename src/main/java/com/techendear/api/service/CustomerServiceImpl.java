package com.techendear.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techendear.api.domain.Customer;
import com.techendear.api.repository.CustomerRepository;
import com.techendear.api.util.MapToEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MapToEntity<Customer> mapToEntity;

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		return this.customerRepository.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomerByFirstName(String firstName) {
		return this.customerRepository.findByFirstName(firstName);
	}

	@Override
	public List<Customer> getAllCustomerByLastName(String lastName) {
		return this.customerRepository.findByLastName(lastName);
	}

	@Override
	public List<Customer> getAllCustomerByContactNumber(String contact) {
		return this.customerRepository.findByContact(contact);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> updateCustomer(Long id, Map<Object, Object> fields) {
		return this.customerRepository.findById(id).map(customer -> {
			this.mapToEntity.mapToEntity(fields, customer);
			return this.customerRepository.save(customer);
		});
	}

	@Override
	public void deleteCustomerById(Long id) {
		this.customerRepository.deleteById(id);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		this.customerRepository.delete(customer);
	}

}
