package com.example.demo.posts.web.dto;

import lombok.Getter;

// 수정
// 수정은 제목, 내용만 변경가능
@Getter
public class PostsUpdateRequestDto {
	private String title;
	private String content;
	
	
}
