package com.org.postal.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="locality")
public class Locality {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="postal_code")
	private int postalCode;
	
	@Column(name="localityName")
	private String name;
	
	
	public Locality() {
		
	}
	
	
	public Locality(int postalCode, String name) {
		this.postalCode = postalCode;
		this.name = name;
	}

	public long getId() {
		return id;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Locality [id=" + id + ", postalCode=" + postalCode + ", name=" + name + "]";
	}
	
	

}
