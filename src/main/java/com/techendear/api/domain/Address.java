package com.techendear.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@SequenceGenerator(name = "address_id", sequenceName = "address_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id")
	private Long id;
	private String line;
	private String city;
	private String state;
	private String country;
	private Integer pin;
	
	@JsonBackReference
	@OneToOne(mappedBy = "address")
	private Customer customer;
}
