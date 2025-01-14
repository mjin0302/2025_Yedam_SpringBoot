package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired 
	BoardService service;
	
	@Test
	@DisplayName("게시글 수정")
	public void update() {
		// given
		// 실재애전 존재하는 번호인지 확인 할 것
		BoardDTO board = BoardDTO.builder()
								 .bno(4L)
								 .title("서비스 수정")
								 .content("내용 수정")
								 .writer("작성자 수정")
								 .build();
		
		// when
		boolean result = service.modify(board);
		
		// then
		assertThat(result).isEqualTo(true);
	}
	
}
