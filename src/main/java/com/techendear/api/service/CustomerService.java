package com.techendear.api.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.techendear.api.domain.Customer;

public interface CustomerService {

	public Optional<Customer> getCustomerById(Long id);

	public List<Customer> getAllCustomers();

	public List<Customer> getAllCustomerByFirstName(String firstName);

	public List<Customer> getAllCustomerByLastName(String lastName);

	public List<Customer> getAllCustomerByContactNumber(String contact);

	public Customer addCustomer(Customer customer);

	public Optional<Customer> updateCustomer(Long id, Map<Object, Object> fields);

	public void deleteCustomerById(Long id);

	public void deleteCustomer(Customer customer);

}
