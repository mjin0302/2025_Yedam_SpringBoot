package com.example.demo;

import org.junit.jupiter.api.Test;

public class LombokTest {
	
	@Test
	public void test() {
		SampleDto dto = SampleDto.builder()
								 .name("aaa")
								 .tel("aaa")
								 .age(10)
								 .build();
		System.out.println(dto);
	}
}
