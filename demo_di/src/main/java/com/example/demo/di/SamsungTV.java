package com.example.demo.di;

import lombok.Data;

// @Component // 클래스를 객체로 생성해서 컨테이너에 미리 담아놓음
@Data
public class SamsungTV implements TV {
	
	final Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성 TV--볼륨 up");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성 TV--볼륨 down");
	}
}
