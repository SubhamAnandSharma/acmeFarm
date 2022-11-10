package com.masai.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentCustomerSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique =true)
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public CurrentCustomerSession(Integer customerId, String uuid, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	public CurrentCustomerSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CurrentCustomerSession [id=" + id + ", customerId=" + customerId + ", uuid=" + uuid + ", localDateTime="
				+ localDateTime + "]";
	}
	
	

}
