package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc // 모의 서버
@SpringBootTest
public class BoardControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("조회 컨트롤러")
	void list() throws Exception{
		mvc.perform(get("/board/list"))
		   .andExpect(status().isOk());
//		   .andDo(MockMvcResultHandlers.print()); // 화면에 찍어주는 애?
	}
	
    @Test
    @DisplayName("main 테스트")
    void main() throws Exception  {
    	String param = "title=comtest&content=내용&writer=kim";
    	mvc.perform(post("/board/register") // => /board/register에 post방식으로 요청
    	   .content(param)
    	   .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//    	).andExpect(status().isOk())
//         .andExpect((ResultMatcher) content().string("main"))
//         .andDo(MockMvcResultHandlers.print());
         ;  
    }
}
