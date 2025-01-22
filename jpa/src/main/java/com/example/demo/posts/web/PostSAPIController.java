package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostSAPIController {
	
	final PostsService pService;
	
	// 등록
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		pService.save(dto);
		return dto;
	}
	
	// 수정
	@PutMapping("/api/v1/posts/{id}")
	public PostsUpdateRequestDto update(@RequestBody PostsUpdateRequestDto dto, 
			                        @PathVariable(name = "id") Long id) {
		
		pService.update(id, dto);
		return dto;
	}
}
