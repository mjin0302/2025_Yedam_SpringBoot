package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ReplyServiceTest {
	
	@Autowired ReplyService replyService;

	// @Test
	@DisplayName("댓글 조회")
	public void getList() {
		// given

		// when
		//List<ReplyDTO> list = replyService.getList(500L);

		// then
		
		//log.info("조회 => " + list.toString());
		
		// assertThat(bno).isEqualTo(dto.getBno());
		//assertThat(list).isNotNull(); // 반환값이 true, false
	}
	
	@Test
	@DisplayName("댓글 수정")
	public void update() {
		// given
		ReplyDTO reply = ReplyDTO.builder()
				   .rno(30L)          // 실행전 존재하는 번호인지 확인할 것
				   .reply("댓글수정")
				   .replyer("김수정")
				   .build();

		// when
		boolean result = replyService.modify(reply);

		// then
		assertThat(result).isEqualTo(true);
	}
}
