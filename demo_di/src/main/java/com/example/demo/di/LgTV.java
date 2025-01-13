package com.example.demo.di;

import lombok.Data;

@Data
// @Component // 클래스를 객체로 생성해서 컨테이너에 미리 담아놓음
public class LgTV implements TV {

	final Speaker speaker;	// final만 선언하면 @Autowired를 붙여준것과 똑같음
	int price;

	// 2. setter
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}

	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
