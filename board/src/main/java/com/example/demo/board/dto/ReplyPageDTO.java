package com.example.demo.board.dto;

import java.util.List;

import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt;	// 전체 건수
	Paging paging;			// 페이징 계산해줌
	private List<ReplyDTO> list;
	
}
