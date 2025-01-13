package com.example.demo.di;

import org.springframework.stereotype.Component;

import lombok.Data;

// 생성자
@Component
@Data
public class Resutaurant {
	
	// final로 인해서 getter, setter 생성 
	private final Chef chef;
	
//	@Autowired
//	private Chef chef;
}
