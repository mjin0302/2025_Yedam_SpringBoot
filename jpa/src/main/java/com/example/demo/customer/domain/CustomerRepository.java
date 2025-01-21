package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// 비워져있어도 
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//	@Query("SELECT c FROM Customer c WHERE id = ?1 ORDER BY name DESC")
	@Query("SELECT c.name FROM Customer c WHERE id = :id and phone = :phone ORDER BY name DESC")
//	public Optional<Customer> findById(Long id);
	public Optional<Customer> findById(@Param("id") Long id,
			                           @Param("phone") String phone);
	
	public List<Customer> findByNameLike(String keyword);
	
	// 이름 or phone 으로 검색 후 name기준으로 desc 정렬
	public List<Customer> findByNameLikeOrPhoneLikeOrderByNameDesc(String name, String phone);

}
