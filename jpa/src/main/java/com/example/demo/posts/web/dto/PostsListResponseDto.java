package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

// 전체조회
@Getter
public class PostsListResponseDto {
	private Long id;
	private String title;
	private String author;
	
	public PostsListResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
	}
}
