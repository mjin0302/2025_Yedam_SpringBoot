package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository customer;
	@Autowired AddressRepository addrRepository;
	
	@Test
	@DisplayName("고객등록")
	public void insert() {
		
		// given
		Customer cust = new Customer("홍길동", "011-1111-2222");
				
		// when
		customer.save(cust);
		addrRepository.save(Address.builder()
				             .address("대구시 ")
//				             .customer(cust)
				             .build());
		System.out.println("id => " + cust.getId());
		
		// then
		// 단건조회 결과와 비교
		Optional<Customer> result = customer.findById(1L);
		Optional<Address> addrResult = addrRepository.findById(1L);
		
		System.out.println("address => " + addrResult.toString());
		assertThat( result.get().getName()).isEqualTo("홍길동");
		
	}
	
//	@Test
	@DisplayName("고객수정")
	public void update() {
		// given
		Customer cust = new Customer("홍길동", "011-1111-2222");
		customer.save(cust);
		
		// when
		Optional<Customer> result = customer.findById(1L);
		result.get().setPhone("2222-3333");
		customer.save(result.get());
	}
	
	//@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%im%";
		List<Customer> list = customer.findByNameLike(name);
		System.out.println(list);
	}
	
//	@Test
	@DisplayName("이름과 폰 검색")
	public void findByNamePhone() {
		String name = "%sssssssssssssssssss%";
		String phone = "%-%";
		
		List<Customer> list = customer.findByNameLikeOrPhoneLikeOrderByNameDesc(name, phone);
		System.out.println(list);
	}
	
//	@Test
	@DisplayName("아이디 검색")
	public void findById() {
		Long id = 1l;
		
		Optional<Customer> cust = customer.findById(id, "010");
		System.out.println(cust.get());
	}
}
