package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
public class ReplyControllerTest {
	
    @Autowired MockMvc mvc;

    @Autowired ObjectMapper objectMapper;

    //@Test
    @DisplayName("reply 등록")
    void register() throws Exception {
    	//given
    	String requestBody = """
    			{
    			  "bno": 490,
    			  "reply": "댓글등록",
    			  "replyer": "이순신"
    			}
    			""";

    	//when //then
    	// perform -> 요청하는 것 (fetch .then .then 이랑 비슷한 구조임)
    	mvc.perform(post("/replies/new")
    	    	     .content(requestBody)
    	    	     .contentType(MediaType.APPLICATION_JSON_VALUE)
    	)
    	.andExpect(status().isOk())	// 요청한 결과가 넘어옴
        .andDo(MockMvcResultHandlers.print());

    }
    
    // @Test
    @DisplayName("reply 수정")
    void modify() throws Exception {
    	//given
    	String requestBody = """
    			{
    			  "reply": "댓글수정",
    			  "replyer": "이순신 수정"
    			}
    			""";

    	//when //then
    	mvc.perform(put("/replies/38")
    	    	     .content(requestBody)
    	    	     .contentType(MediaType.APPLICATION_JSON_VALUE)
    	)
    	.andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());

    }
    
    // @Test
    @DisplayName("reply 단건 조회")
    void getreply() throws Exception {
    	// given
    	Long rno = 2L;
    	String url = "/replies/" + rno;
    	
    	// when
    	mvc.perform(
    			get(url).
    			accept(MediaType.APPLICATION_JSON_VALUE)
		)
    	
    	// then
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$.reply").value("댓글수정"))
        .andDo(print()) ;
    }
    
    //@Test
    @DisplayName("reply 삭제")
    void delete() throws Exception {
    	//given
    	
    	//when //then
    	mvc.perform(MockMvcRequestBuilders.delete("/replies/38")
    	    	     .contentType(MediaType.APPLICATION_JSON_VALUE)
    	)
    	.andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());

    }
}
