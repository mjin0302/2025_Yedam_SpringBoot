package com.example.demo.customer.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;

@Getter 
@Entity // 필드명에 맞게 테이블 생성해줌
// @Table(name = "cust") // 테이블 이름 지정
public class Customer {
	
	@Id	// 기본키임
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// @Column( name = "username", length = 50, nullable = false)
	private String name;
	
	// @Column(columnDefinition = "clob")
	private String phone;
	
//	@OneToOne
//	@JoinColumn(name = "address_id")
//	Address address;
	
//	@OneToMany(mappedBy = "address")
//	List<Address> address;
	
	@Transient // 컬럼 생성 안함
	private String addr;

	@Transient
	private String grade;

	public Customer(String name, String phone) {
		
		this.name = name;
		this.phone = phone;
	}
	
	public Customer() { }

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
