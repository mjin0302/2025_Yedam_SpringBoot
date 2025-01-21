package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.securing.service.CustomerUser;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/home")
	public void home() {
		
		log.info("userdetail : " + SecuUtil.getUser().getDeptName());
		log.info("session : " + session.getAttribute("deptName"));
		
	}
}
