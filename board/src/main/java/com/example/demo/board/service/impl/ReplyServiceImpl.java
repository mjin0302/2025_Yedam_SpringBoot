package com.example.demo.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper mapper;
	
	// 등록
	@Override
	public boolean register(ReplyDTO dto) {
		return mapper.insert(dto) == 1 ? true : false;
	}

	// 수정
	@Override
	public boolean modify(ReplyDTO dto) {
		return mapper.update(dto) == 1 ? true : false;
	}

	// 삭제
	@Override
	public boolean remove(Long rno) {
		return mapper.delete(rno) == 1 ? true : false;
	}

	// 전체조회
	@Override
	public ReplyPageDTO getList(ReplySearchDTO searchDto, Long bno) {
		return new ReplyPageDTO(
				mapper.getCountByBno(bno), 
				mapper.getList(searchDto, bno));
	}

	@Override
	public ReplyDTO get(Long rno) {
		// TODO Auto-generated method stub
		return null;
	}


}
