package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.securing.mapper.UserMapper;
import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;

@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void test() {
		UserDTO user = mapper.getUser("user");
		//List<RoleDTO> list = mapper.getRole(user.getId());
		
		System.out.println(user);
		//System.out.println(list);
	}
}
