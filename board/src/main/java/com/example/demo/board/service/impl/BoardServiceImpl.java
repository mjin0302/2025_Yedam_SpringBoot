package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;

	// 등록
	@Override
	public void register(BoardDTO dto) {
		mapper.insert(dto);
	}

	// 수정
	@Override
	public Boolean modify(BoardDTO dto) {
		return mapper.update(dto) == 1 ? true : false;
	}

	// 삭제
	@Override
	public Boolean remove(Long bno) {
		return mapper.delete(bno) == 1 ? true : false;
	}

	// 단건조회
	@Override
	public BoardDTO get(Long bno) {
		return mapper.read(bno);
	}

	// 전체조회
	@Override
	public List<BoardDTO> getList() {
		return mapper.getList();
	}

}
