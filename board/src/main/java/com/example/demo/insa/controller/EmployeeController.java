package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.insa.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmployeeController {
	/*
	 * 실습 : 사원등록, 사원 전체조회 구현
	 * 
	 * 요구사항
	 * 1. jobs select -> 테이블 조회
	 * 2. departments select -> 부서 조회
	 * 3. @Validated : 유효성 체크하기 (Not Null -> 필수 입력항목 없으면 등록 페이지로 돌려버리기)
	 * 
	 * */
	
	private final EmployeeService empService;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		model.addAttribute("list", empService.getList());
	}
	
	
	
	// jobs 전체조회, departments 전체조회를 해서 등록페이지 select태그에 option을 th:each 돌려서 뿌리기
	// 등록 페이지 로딩
	@GetMapping("register")
	public void register() {
		//
	}
}
