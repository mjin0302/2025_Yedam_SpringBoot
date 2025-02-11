package lambdaStream;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleColon {

	@Test
	@DisplayName("메서드참조(더블콜론)")
	public void doubleColon() {
		List<String> fruit = Arrays.asList("사과", "바나나", "포도");
		
//		for(String test : fruit) {
//			System.out.println(test);
//			
//		}
		
		// s가 fruit의 요소 하나하나임
		fruit.forEach(s -> System.out.println("lambda" + s));
		
		// 
		fruit.forEach(System.out::println);
	}
	
	
}
