package com.techendear.api.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({ AuditingEntityListener.class })
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id", sequenceName = "customer_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
	private Long id;
	private String firstName;
	private String lastName;
	private String sex;
	private Integer age;
	private Timestamp dob;
	private String email;
	private String contact;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createdDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
}
