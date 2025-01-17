package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	private final ReplyMapper rMapper;

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
	@Transactional
	public Boolean remove(Long bno) {
		// 댓글 삭제
		rMapper.deleteByBno(bno);
		
		// 게시글 삭제
		return mapper.delete(bno) == 1 ? true : false;
	}

	// 단건조회
	@Override
	public BoardDTO get(Long bno) {
		return mapper.read(bno);
	}

	// 전체조회
	@Override
	public List<BoardDTO> getList(BoardSearchDTO dto) {
		return mapper.getList(dto);
	}

	// 총 게시글 수 조회
	@Override
	public int getCount(BoardSearchDTO searchDto) {
		
		return mapper.getCount(searchDto);
	}

}
