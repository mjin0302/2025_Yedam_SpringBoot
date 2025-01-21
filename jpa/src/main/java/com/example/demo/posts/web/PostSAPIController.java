package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostSAPIController {
	
	final PostsService pService;
	
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		pService.save(dto);
		return dto;
	}
}
