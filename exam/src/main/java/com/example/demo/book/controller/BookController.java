package com.example.demo.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.book.service.BookDTO;
import com.example.demo.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/book/*")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bService;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	// 전체조회
	@GetMapping("/list")
	public void list (Model model) {
		model.addAttribute("list", bService.getList());
	}
	
	// 등록 페이지로 이동
	@GetMapping("/register")
	public void register(BookDTO board) { }
	
	// 등록 처리 핸들러
	@PostMapping("/register")
	public String register(@Validated BookDTO dto,
				           BindingResult bindingResult,
						   RedirectAttributes rttr) {

		// 스프링이 제공하는 검증 에러를 보관하는 곳
		// bindingResult -> 여기에 하나라도 에러가 있다면 등록페이지로 보내겠다
		if(bindingResult.hasErrors()) {
			return "book/register";
		}
		
		log.info("register => " + dto);
		bService.insert(dto);
		
		rttr.addAttribute("result", true);
		// redirect => controller의 list() 핸들러로 가라 !!
		
		return "redirect:/book/list";
	}
	
	// 대여현황조회
	@GetMapping("/rentList")
	public void rentList (Model model) {
		model.addAttribute("list", bService.rentList());
	}
}
