package com.techendear.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techendear.api.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

	public List<Customer> findByContact(String contact);
}
