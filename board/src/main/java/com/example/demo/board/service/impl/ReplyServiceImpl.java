package com.example.demo.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper mapper;
	
	@Autowired BoardMapper bMapper;
	
	// 등록
	@Transactional
	@Override
	public boolean register(ReplyDTO dto) {
		bMapper.updateReplyCnt(dto.getBno(), 1);
		
		return mapper.insert(dto) == 1 ? true : false;
	}

	// 수정
	@Override
	public boolean modify(ReplyDTO dto) {
		return mapper.update(dto) == 1 ? true : false;
	}

	// 삭제
	@Transactional
	@Override
	public boolean remove(Long rno) {
		log.info("remove...." + rno);
		
		ReplyDTO dto = mapper.read(rno);
		
		bMapper.updateReplyCnt(dto.getBno(), -1);
		
		return mapper.delete(rno) == 1 ? true : false;
	}

	// 전체조회
	@Override
	public ReplyPageDTO getList(ReplySearchDTO searchDto, Long bno) {
		
		// 페이징 객체가 이미 만들어져 있어서 재사용
		Paging paging = new Paging();
		int cnt = mapper.getCountByBno(bno);
		
		// paging - 전체 건수, pageUnit, pageNum
		paging.setPage(searchDto.getPage());
		paging.setPageUnit(searchDto.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
				cnt, 
				paging,
				mapper.getList(searchDto, bno));
	}

	// 단건조회
    @Override
    public ReplyDTO get(Long rno) {
    	return mapper.read(rno);
    }

}
