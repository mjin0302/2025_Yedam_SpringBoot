package com.example.demo.board.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	 private Long rno;			// 댓글번호
	 private Long bno;			// 글번호
	 private String reply;		// 댓글
	 private String replyer;	// 작성자
	 
	 @JsonFormat(pattern = "yyyy-MM-dd")
	 private Date replyDate;	// 작성일자
	 
	 @JsonFormat(pattern = "yyyy-MM-dd")
	 private Date updateDate;	// 수정일자
}
