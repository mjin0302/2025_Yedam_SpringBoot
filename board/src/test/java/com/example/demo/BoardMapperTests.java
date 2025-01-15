package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@SpringBootTest
public class BoardMapperTests {
	
	@Autowired BoardMapper mapper;
	
	//@Test
	@DisplayName("게시글 등록")
	public void register() {
		// given
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(10);
//		dto.setTitle(null);
//		dto.setContent(null);
//		dto.setWriter(null);
		String title = "제목 등록";
		
		BoardDTO dto = BoardDTO.builder()
								.title(title)
								.content("내용등록")
								.writer("작성자 등록")
								.build();
		
		// when
		int cnt = mapper.insert(dto);
		
		// then
		// 매퍼가 실행된 결과가 1이랑 같은지?
		assertThat(cnt).isEqualTo(1);
	}
	
	//@Test
	@DisplayName("게시글 수정")
	public void modify() {
		String title = "제목 수정";
		String content = "내용 수정";
		String writer = "작성자 수정";
		
		BoardDTO board = BoardDTO.builder()
								 .title(title)
								 .content(content)
								 .writer(writer)
								 .bno(1L)
								 .build();
		
		int cnt = mapper.update(board);
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void remove() {
		int cnt = mapper.delete(7L);
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 단건 조회")
	public void get() {
		// given
		long bno = 3L;
		
		// when
		BoardDTO dto = mapper.read(bno);
		
		// then
		log.info("단건조회 => " + dto.toString());
		
		// assertThat(bno).isEqualTo(dto.getBno());
		assertThat(dto).isNotNull(); // 반환값이 true, false
	}
	
	@Test
	@DisplayName("게시글 전체조회")
	public void getList() {
		// given
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		
		//when
		List<BoardDTO> list = mapper.getList(search);
		
		// then
		list.forEach(board -> log.info(board.toString()));
	}
}
