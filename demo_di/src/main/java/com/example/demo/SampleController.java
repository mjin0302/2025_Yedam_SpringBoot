package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 컨트롤러라는걸 선언해줌
@RequestMapping("/sample/")
public class SampleController {

	// Logger log = LoggerFactory.getLogger(SampleController.class);
	
	
	
	
	
	
	
	
	
	
	// Query String 방식 ~~~ ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	@ModelAttribute("dept")
	public List<String> deptList() {
		return Arrays.asList("기획", "개발", "인사");
	}
	
	@GetMapping("/ex03Model")
	public ModelAndView ex03Model(@ModelAttribute(name = "todo") TodoDTO dto, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());
		
		log.debug("TodoDTO => " + dto);

		return mv;
	}

	// 커맨드 객체는 자동으로 view페이지에 전송된다.
	@GetMapping("/ex03")
	public String ex03(TodoDTO dto, Model model) {
		model.addAttribute("serverTime", new Date());
		log.debug("TodoDTO => " + dto);

		return "sample";
	}

	@PostMapping("/ex02Bean")
	public String ex02Bean(SampleDtoList dtoList) {
		log.debug("dtoList => " + dtoList);
		
		return "sample";
	}

	// http://localhost:81/insa/sample/ex02List?hobby=read&hobby=game
	// hobby가 여러개일 때
	// 배열로 받을 때는 @RequestParam 얘는 필수임
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam List<String> hobby) {
		log.debug("hobby => " + hobby);
		return "sample";
	}

	// http://localhost:81/insa/sample/ex02?name=kim&age=10
	// @RequestParam은 생략이 가능함
	// required => 값이 true이면 주소창에 무조건 값이 있어야함
	// required => 값이 false일 때는 파라미터에 값이 없어도 됌!!
	// 없을 시 => defaultValue 값으로 세팅해줌
	@GetMapping("/ex02")
	public String ex01(@RequestParam(name = "username") String name,
					   @RequestParam(required = false, defaultValue = "5") int age) {

		log.info("name => " + name);
		log.info("age => " + age);
		return "sample";
	}

	// vo로 받는 방법
	@GetMapping("/ex01")
	public String ex01(SampleDto dto) {
		log.debug(dto.toString());
		return "sample";
	}

	@GetMapping("a")
	// @RequestMapping(value="a", method = { RequestMethod.GET, RequestMethod.POST }
	// )
	public String main() {
		System.out.println("sample a");
		log.info("sample a");

		return "sample";
	}

	@GetMapping("b")
	public String basicb() {
		System.out.println("sample b");
		log.info("sample b");

		return "sample";
	}
}
