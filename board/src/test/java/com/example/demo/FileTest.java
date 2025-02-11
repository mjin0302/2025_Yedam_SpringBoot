package com.example.demo;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileTest {
	
	@Test
	public void fileTest() {
		
		// file을 복사, 생성, 삭제, 정보읽기 등 파일을 다루는 클래스
//		File file = new File("c:/Temp/a.txt");
//		file.delete(); // 파일 삭제
//		System.out.println("파일 길이 : " + file.length());
//		
//		// 폴더 생성
//		File folder = new File("c:/Temp/txt");
//		folder.mkdir();
		
		// 폴더 목록 출력
		File file = new File("c:\\Users");
		String[] list = file.list();
		
		for(int i=0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
	}
}
