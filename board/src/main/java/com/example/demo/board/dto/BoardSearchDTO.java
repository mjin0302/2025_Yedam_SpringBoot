package com.example.demo.board.dto;

import lombok.Data;

@Data
public class BoardSearchDTO {
	int start;	// 시작페이지
	int end;	// 끝 페이지
	
	String type;	// 검색타입
	String keyword;	// 검색 키워드
	int pageUnit; 	// 한페이지에 몇개씩 보여줄껀지
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
