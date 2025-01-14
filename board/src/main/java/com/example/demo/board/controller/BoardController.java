package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")
	public void list (Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
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
	public void register(Model model) { }
	
//	@PostMapping("/register")
//	public String register(BoardDTO dto) {
//		log.info("register => " + dto);
//		
//		service.register(dto);
//		
//		// redirect => controller의 list() 핸들러로 가라 !!
//		return "redirect:/board/list";
//	}
	
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes rttr) {
		log.info("register => " + dto);
		service.register(dto);
		
		// rttr.addAttribute("result", true);
		rttr.addFlashAttribute("result", true);
		// redirect => controller의 list() 핸들러로 가라 !!
		return "redirect:/board/list";
	}
	
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam (name="bno") Long bno, Model model) {
		BoardDTO dto = service.get(bno);
		model.addAttribute("board", dto);
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO dto) {
		service.modify(dto);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam (name="bno") Long bno) {
		service.remove(bno);
		
		return "redirect:/board/list";
	}
	
}
