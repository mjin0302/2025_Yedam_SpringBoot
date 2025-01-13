package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di.Resutaurant;
import com.example.demo.di.TV;

@SpringBootTest
public class DiTest {

	//@Autowired TV tv; // @Autowired -> 얘를 통해서 컨테이너에 담겨있는 클래스를 가져옴 
	// @Autowired ApplicationContext context; // 스프링 IoC 컨테이너(빈을 담고있는)
	
	//@Test
	//@DisplayName("DI test")
//	public void test() {
//
//		SamsungTV tv = new SamsungTV(); // LgTV로 교체해보세요
//
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//		
//		LgTV lgtv = new LgTV(); // LgTV로 교체해보세요
//
//		lgtv.powerOn();
//		lgtv.volumeUp();
//		lgtv.volumeDown();
//		lgtv.powerOff();
//		
//		TV newTv = new SamsungTV();
//		
//		newTv.powerOn();
//		newTv.volumeUp();
//		newTv.volumeDown();
//		newTv.powerOff();
		
		//TV tv = context.getBean(TV.class);
		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
//	}
	

	@Autowired Resutaurant resutaurant;
	
	@Test
	public void RestaurantTest() {
		resutaurant.getChef().getName();
	}
	
}