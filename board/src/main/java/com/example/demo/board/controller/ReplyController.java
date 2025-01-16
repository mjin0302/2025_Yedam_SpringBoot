package com.example.demo.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/replies/")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService service;
	
	// 등록 처리
	@PostMapping("/new")
	public ReplyDTO register(@RequestBody ReplyDTO dto) {
		service.register(dto);
		return dto;
	}
	
	// 수정 처리
	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyDTO dto,
			                             @PathVariable(name="rno") Long rno) {
		dto.setRno(rno);
		
		return service.modify(dto) == true 
				? new ResponseEntity<>("success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 삭제 처리
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable Long rno) {
		
		return service.remove(rno) == true 
		? new ResponseEntity<>("success", HttpStatus.OK) 
		: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 단건조회
	@GetMapping("/{rno}")
	public ReplyDTO get(@PathVariable("rno") Long rno) {
		return service.get(rno);
	}
	
	// 댓글 목록 조회
	// localhost:81/replies/pages/2/1
	@GetMapping("/pages/{bno}/{page}")
	public ReplyPageDTO getList(@PathVariable(name="page") int page,
				                @PathVariable(name="bno") Long bno) {
		
		ReplySearchDTO searchDto = new ReplySearchDTO(page, 10);
		
		return service.getList(searchDto, bno);
	}
	
	
}
