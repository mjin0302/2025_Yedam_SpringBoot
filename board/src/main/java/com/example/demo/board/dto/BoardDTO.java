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
	private Long bno;
	
	// @NotBlank ↓
	// 공백이거나 null일 때를 체크해 컨트롤러에서 지정한 페이지로 돌려버린다 
	@NotBlank(message = "이름을 입력하세요.")
	private String title;
	
	@NotBlank
	private String content;
	
	@NotBlank
	private String writer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;
}
