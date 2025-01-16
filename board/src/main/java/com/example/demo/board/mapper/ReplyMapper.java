package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplySearchDTO;

public interface ReplyMapper {

	// 등록
	public int insert(ReplyDTO dto);
	
	// 수정
	public int update(ReplyDTO dto);

	// 삭제
	public int delete(Long rno);

	// 전체조회
	public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri, @Param("bno") Long bno);

	public int getCountByBno(Long bno);

}
