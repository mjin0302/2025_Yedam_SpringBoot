package com.example.demo.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;
}
