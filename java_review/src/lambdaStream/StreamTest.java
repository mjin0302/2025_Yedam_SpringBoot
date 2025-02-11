package lambdaStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {
	
	@Test
	@DisplayName("Stream")
	public void array() {
		String[] strArr = {"키위", "포도", "바나나", "사과","감", "사과"};
		
		long cnt = Stream.of(strArr) // String 생성
						 .filter(s -> s.length() > 1)
						 .distinct()
						 .count() // return 타입이 long 타입이다 (최종함수)
		;
		
		System.out.println("cnt => " + cnt); // 결과 4
		
		
		List<String> fruit = Stream.of(strArr) // String 생성
								   .filter(s -> s.length() > 1)
								   .distinct()
								   .collect(Collectors.toList()) // 최종함수
		;
		
		
		Stream.of(strArr) // String 생성
			   .filter(s -> s.length() > 1)
			   .distinct()
			   .toList() // 중간함수 collect와 결과값은 똑같은데 중간함수라서 뒤에 다른 함수를 더 사용가능
			   .forEach(f -> System.out.println(f))
		;
		
		System.out.println("fruit => " + fruit);	// 결과
		
		
		Stream.of(strArr) // String 생성
				   .filter(s -> s.length() > 1)	// 중간연산함수 n개 가능
				   .sorted()					// 오름차순 출력
				   .forEach(System.out::println);	// 최종함수는 마지막에 하나만 가능
		;
		
		
		Stream.of(strArr) // String 생성
		   .filter(s -> s.length() > 1)	// 중간연산함수 n개 가능
		   .sorted((a,b) -> b.compareTo(a))	// 역순 출력
		   .forEach(System.out::println);	// 최종함수는 마지막에 하나만 가능
		;
	}
}
