package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

// 단건조회
@Getter
public class PostResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	
	public PostResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
	}
}
