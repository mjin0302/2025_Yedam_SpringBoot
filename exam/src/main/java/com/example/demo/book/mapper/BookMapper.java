package com.example.demo.book.mapper;

import java.util.List;

import com.example.demo.book.service.BookDTO;

public interface BookMapper {

	// 등록
	public int insert(BookDTO dto);

	// 수정
	public int update(BookDTO dto);

	// 삭제
	public int delete(Long bookNo);

	// 전체조회
	public List<BookDTO> getList();

	// 단건조회
	public BookDTO read(Long bookNo);
	
	// 대여현황조회
	public List<BookDTO> rentList();
}
