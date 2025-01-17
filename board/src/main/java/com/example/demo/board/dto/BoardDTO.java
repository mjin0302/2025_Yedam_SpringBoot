package com.example.demo.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	private Long bno;	// 게시글 번호
	
	// @NotBlank ↓
	// 공백이거나 null일 때를 체크해 컨트롤러에서 지정한 페이지로 돌려버린다 
	@NotBlank(message = "이름을 입력하세요.")
	private String title;	 // 제목
	
	@NotBlank
	private String content;	 // 내용
	
	@NotBlank
	private String writer;	 // 작성자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;	 // 작성일자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate; // 수정일자
	
	private int replycnt;	 // 댓글 수
}
