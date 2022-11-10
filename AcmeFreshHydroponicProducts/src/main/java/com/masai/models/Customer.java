package com.masai.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@Size(max = 10,min = 10)
	@Column(unique = true)
	@NotNull(message = "Mobile is mandatory")
	private String mobileNo;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	
	@Email(message="Enter your Email properly")
	@NotNull(message = "Email is mandatory")
	private String email;

	@Embedded
	Address address;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Customer(Integer id, @NotNull(message = "Name is mandatory") String name,
			@Size(max = 10, min = 10) @NotNull(message = "Mobile is mandatory") String mobileNo,
			@NotNull(message = "Password is mandatory") String password,
			@Email(message = "Enter your Email properly") @NotNull(message = "Email is mandatory") String email) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
	}
	

	public Customer(Address address) {
		super();
		this.address = address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
