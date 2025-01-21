package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	 *  /main -> permitAll()
	 *  /board/* -> 로그인
	 *  /emp/*, /dept/* -> admin
	 *  
	 * */
	
	private final EmployeeService empService;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		model.addAttribute("list", empService.getList());
	}
	
	@GetMapping("/get")
	public void read(@RequestParam (name="empId") Long empId, Model model) {
		EmpDTO dto = empService.read(empId);
		System.out.println("read DTO => " + dto);
		model.addAttribute("emp", dto);
	}
	
	
	@GetMapping("/register")
	public void register(Model model, EmpDTO dto) {
		model.addAttribute("jobs", empService.getJobs());
	}
	
	// jobs 전체조회, departments 전체조회를 해서 등록페이지 select태그에 option을 th:each 돌려서 뿌리기
	// 등록 페이지 로딩
	@PostMapping("/register")
	public String register(@Validated EmpDTO dto,
					       BindingResult bindingResult,
			               RedirectAttributes rttr) {

		if(bindingResult.hasErrors()) {
			return "emp/register";
		}
		
		log.info("register => " + dto);
		empService.insert(dto);
		
		// rttr.addAttribute("result", true);
		rttr.addFlashAttribute("result", true);
		// redirect => controller의 list() 핸들러로 가라 !!
		return "redirect:/emp/list";
	}
}
