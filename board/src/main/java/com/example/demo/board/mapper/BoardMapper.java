package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;

public interface BoardMapper {
	
	// 등록
	public int insert(BoardDTO dto);
	
	// 수정
	public int update(BoardDTO dto);
	
	// 삭제
	public int delete(Long bno);
	
	// 단건조회
	public BoardDTO read(Long bno);
	
	// 전체조회
	public List<BoardDTO> getList(BoardSearchDTO dto);

	// 전체 게시글 수 조회
	public int getCount(BoardSearchDTO searchDto);
	
	// 댓글 등록, 삭제될 때 댓글 수 증가 및 감소 하기
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);

}
