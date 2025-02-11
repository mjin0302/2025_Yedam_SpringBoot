package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputStreamTest {
	
//	@Test
	public void test1() throws IOException {
		
		// 키보드 입력을 파일로 저장
//		FileWriter fw = new FileWriter("c:/Temp/data.txt");
//		
//		fw.write("ongsim");	// data.txt파일에 내용생성
//		fw.close();
		
		FileWriter fw2 = new FileWriter("c:/Temp/data.txt");
		
		int readByte;
		while((readByte = System.in.read()) != -1) {
			fw2.write(readByte);
		}
		fw2.close();
	}
	
	// @Test
	@DisplayName("파일 입력")
	public void test2() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		
		int readByte;
		
		while((readByte = fi.read()) != -1) {
			System.out.print((char)readByte);
		}
		
		fi.close();
	}
	
	// @Test
	@DisplayName("파일 복사")
	public void test3() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		FileOutputStream fo = new FileOutputStream("c:/Temp/data2.txt");
		
		int readByte;
		
		while((readByte = fi.read()) != -1) {
			fo.write(readByte);
		}
		
		fo.close();
		fi.close();
	}
}
