package com.example.demo.book.service;import java.util.List;

public interface BookService {
	
	// 등록
	public boolean insert(BookDTO dto);
	
	// 수정
	public boolean update(BookDTO dto);
	
	// 삭제
	public boolean delete(Long bookNo);
	
	// 전체조회
	public List<BookDTO> getList();
	
	// 단건조회
	public BookDTO read(Long bookNo);
	
	// 대여현황조회
	public List<BookDTO> rentList();
}
