package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	// 전체조회
	@GetMapping("/list")
	public void list (Model model, 
			          BoardSearchDTO searchDto,
			          Paging paging) {
		log.info("list");
		
		// 페이징처리
		paging.setTotalRecord(service.getCount(searchDto));
		
		// 페이징 dto에 값 세팅
		searchDto.setStart(paging.getFirst());
		searchDto.setEnd(paging.getLast());
		
		model.addAttribute("list", service.getList(searchDto));
	}
	
//	@GetMapping("/list")
//	@ResponseBody // 결과값을 돌려주는 애
//	public List<BoardDTO> list() {
//		log.info("list");
//		
//		return service.getList();
//	}
	
	// 등록 페이지로 이동
	@GetMapping("/register")
	public void register(BoardDTO board) { }
	
//	@PostMapping("/register")
//	public String register(BoardDTO dto) {
//		log.info("register => " + dto);
//		
//		service.register(dto);
//		
//		// redirect => controller의 list() 핸들러로 가라 !!
//		return "redirect:/board/list";
//	}
	
	// 등록 처리하는 핸들러
	@PostMapping("/register")
	public String register(@Validated BoardDTO dto,
			               BindingResult bindingResult,
						   RedirectAttributes rttr) {
		
		// 스프링이 제공하는 검증 에러를 보관하는 곳
		// bindingResult -> 여기에 하나라도 에러가 있다면 등록페이지로 보내겠다
		if(bindingResult.hasErrors()) {
			return "board/register";
		}
		
		log.info("register => " + dto);
		service.register(dto);
		
		// rttr.addAttribute("result", true);
		rttr.addFlashAttribute("result", true);
		// redirect => controller의 list() 핸들러로 가라 !!
		return "redirect:/board/list";
	}
	
	// 수정하는 페이지 (정보를 조회하기 위해서 단건 조회와 같이 사용)
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam (name="bno") Long bno, Model model) {
		BoardDTO dto = service.get(bno);
		model.addAttribute("board", dto);
		
	}
	
	// 수정 기능 핸들러
	@PostMapping("/modify")
	public String modify(BoardDTO dto) {
		service.modify(dto);
		
		return "redirect:/board/list";
	}
	
	// 게시글 삭제 핸들러
	@GetMapping("/remove")
	public String remove(@RequestParam (name="bno") Long bno) {
		service.remove(bno);
		
		return "redirect:/board/list";
	}
	
}
