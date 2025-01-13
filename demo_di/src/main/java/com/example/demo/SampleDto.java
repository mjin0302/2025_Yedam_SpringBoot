package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // 생성자를 대신함 (@NoArgsConstructor, @AllArgsConstructor 같이 넣어야함)
@NoArgsConstructor	// 기본 생성자(필요하면 @AllArgsConstructor 세트)
@AllArgsConstructor	// 모든 필드 초기화 생성자
public class SampleDto {
	
	private String name;
	private int age;
	private String tel;
}
