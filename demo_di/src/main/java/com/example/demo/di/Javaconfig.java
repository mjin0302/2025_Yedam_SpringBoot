package com.example.demo.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 내가만든 클래스가 아니고 외부 라이브러리를 등록할 때 사용하는 어노테이션
// @Configuration // 설정 파일이다 라는걸 알려줌
public class Javaconfig {
	
	@Bean
	public Speaker speaker() {
		return new SonySpeaker();
	}
	
	@Bean
	public TV tv() {
		System.out.println("tv 등록");
		return new LgTV(speaker());
	}
}
