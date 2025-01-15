package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 얘의 리턴값은 모두 데이터임
@RequiredArgsConstructor
@RequestMapping("/dept/") // 주소를 /dept로 시작할꺼임~~
public class DeptController {
	
	private final DeptService service;
	
	// 전체조회
	@GetMapping("list")
	public List<DeptDTO> list() {
		return service.getList(null);
	}
	
	// 단건조회
	@GetMapping("get")
	public DeptDTO read(@RequestParam (name = "deptId") int deptId) {
		return service.read(deptId);
	}
}
