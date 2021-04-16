package com.techendear.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techendear.api.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
