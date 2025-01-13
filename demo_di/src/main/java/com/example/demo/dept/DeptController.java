package com.example.demo.dept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/dept")
@Controller // 필수
public class DeptController {
	
	@GetMapping("/list")
	public void list(Model model) {
		List<DepartmentsDTO> list = new ArrayList<>();
		list.add(DepartmentsDTO.builder().departmentId("10").departmentId("기획").build());
		list.add(DepartmentsDTO.builder().departmentId("20").departmentId("개발").build());
		
		model.addAttribute("list", list);
		
	}
	
	@GetMapping("/info")
	public String info() {
		return "dept/info";
	}
	
	@GetMapping("/insert")
	public String insert() {
		
		return "dept/insert";
	}
	
	@PostMapping("/insert")
	public String insertProc(DepartmentsDTO dto) {
		log.debug("DepartmentsDTO => " + dto);
		
		return "redirect:/dept/list";
	}
	
	@PutMapping("/update")
	public String update() {
		return "dept/update";
	}
}
