package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.mapper.BookMapper;
import com.example.demo.book.service.BookDTO;
import com.example.demo.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	private final BookMapper bMapper;
	
	// 등록
	@Override
	public boolean insert(BookDTO dto) {
		return bMapper.insert(dto) == 1 ? true : false;
	}

	// 수정
	@Override
	public boolean update(BookDTO dto) {
		return bMapper.update(dto) == 1 ? true : false;
	}

	// 삭제
	@Override
	public boolean delete(Long bookNo) {
		return bMapper.delete(bookNo) == 1 ? true : false;
	}

	// 전체조회
	@Override
	public List<BookDTO> getList() {
		return bMapper.getList();
	}

	// 단건조회
	@Override
	public BookDTO read(Long bookNo) {
		return bMapper.read(bookNo);
	}

	// 대여현황조회
	@Override
	public List<BookDTO> rentList() {
		return bMapper.rentList();
	}

}
