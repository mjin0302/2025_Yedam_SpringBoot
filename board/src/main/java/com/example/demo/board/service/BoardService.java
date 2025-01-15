package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;

public interface BoardService {

	// 등록
	public void register(BoardDTO dto);

	// 수정
	public Boolean modify(BoardDTO dto);

	// 삭제
	public Boolean remove(Long bno);

	// 단건조회
	public BoardDTO get(Long bno);

	// 전체조회
	public List<BoardDTO> getList(BoardSearchDTO dto);
	
	// 총 갯수
	public int getCount(BoardSearchDTO searchDto);
}
