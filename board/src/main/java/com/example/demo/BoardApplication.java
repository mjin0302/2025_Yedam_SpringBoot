package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//패키지 아래에 있는 .mapper로 끝나는 파일을 스캔해서 등록 해놓음
@MapperScan(basePackages = "com.example.demo.**.mapper") 
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
