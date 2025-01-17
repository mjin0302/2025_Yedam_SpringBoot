package com.example.demo.board.service;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;

public interface ReplyService {
	
	// 등록
	public boolean register(ReplyDTO dto);
	
	// 수정
	public boolean modify(ReplyDTO dto);
	
	// 삭제
	public boolean remove(Long rno);
	
	// 단건조회
	public ReplyDTO get(Long rno);
	
	// 전체조회
	public ReplyPageDTO getList(ReplySearchDTO searchDto, Long bno);
	
}
