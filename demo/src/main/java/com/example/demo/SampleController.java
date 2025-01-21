package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // return 값은 Json 형식임
public class SampleController {
	
    // produces -> 값을 보낼때 일반 텍스트 값으로 넘겨줄꺼다를 명시하는 것(생략가능, 알아서 변환 된다)
	@GetMapping(value = "/getText", produces = "text/plain;charset:UTF-8")
	public @ResponseBody String getText() {
		return "Hello World!";
	}
	
	@GetMapping(value="/getTextEntity")
	public ResponseEntity<String> getTextEntity() {
		
		return new ResponseEntity<>("안녕하세요", HttpStatus.BAD_GATEWAY);
	}
	
	@ResponseBody // rescontroller에서는 필요없고 어노테이션이 Controller일 때는 반환값이 페이지라서 반환해주는 값은 데이터다 라는걸 명시해줘야하기 때문에 필수
	@GetMapping("/getSample")
	public SampleVO getSample() {
		
		return new SampleVO(100, "옹심", "Kim", new Date());
	}
	
	@GetMapping("/getSampleEntity")
	public ResponseEntity<SampleVO> getSampleEntity() {
		
		SampleVO vo = new SampleVO(100, "길동", "김", new Date());
		
		return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getMap")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sample", new SampleVO(100, "옹심", "Kim", new Date()) );
		map.put("total", 20);
		map.put("success", true);
		
		return map;	
	}
	
	//@GetMapping("/product/{}") -> {}위치에 변수가 들어온다는 걸 명시해줌
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, // @PathVariable -> 알아서 타입변환해줌
				            @PathVariable(name="pid") Integer prdId) { // url에 있는 변수명과 리턴시킬 변수가 다르다면 name 명시해주기
		return new String[] { cat, "" + prdId};
	}
	
	
	@PostMapping("/ticket")
	public List<Ticket> convert(@RequestBody List<Ticket> list) {
		log.info("ticket -> " + list);
		
		return list;
	}
	
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp) {
		log.info("ticket -> " + comp);
		
		return comp;
	}
	
	@PostMapping("/compMap")
	public Map<String, Object> comp(@RequestBody Map<String, Object> comp) {
		
		log.info("ticket -> " + ((Map<String, Object>) ((List<Object>)comp.get("list")).get(0)).get("owner"));
		
		return comp;
	}
		
	@GetMapping("/movie")
	public String movie(@RequestParam(required = false, defaultValue = "20250115") String date) {
		RestTemplate tem = new RestTemplate();
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=" + date;
		JsonNode node = tem.getForObject(uri, JsonNode.class);

		String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		
		return name;
	}
	
	
	
	
	
	
	
	
	
}
