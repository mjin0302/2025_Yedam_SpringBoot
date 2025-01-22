package com.example.demo.posts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.web.dto.PostResponseDto;
import com.example.demo.posts.web.dto.PostsListResponseDto;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;

	// 등록
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();

	}

	// 수정
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());

		return id;
	}

	// 삭제
//	delete() {}

	// 전체조회
	public List<PostsListResponseDto> findAll() {
		List<Posts> result = postsRepository.findAll();
		
//		List<PostsListResponseDto> dtoList = new ArrayList<PostsListResponseDto>();
//		result.forEach(post -> dtoList.add(new PostsListResponseDto(post)) );
//		return dtoList;
		
		// 병렬로 처리하는 로직 그래서 처리가 빠르다
		return result.stream().map(post -> new PostsListResponseDto(post))
				              .collect(Collectors.toList());
	}
	
	// 단건조회
	public PostResponseDto findById(Long id) {
		Optional<Posts> result = postsRepository.findById(id);
		
		return new PostResponseDto(result.get());
	}
}
