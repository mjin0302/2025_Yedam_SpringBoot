package lambdaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class StreamEmpTest {
	
	private static void main(String[] args) {
		
		List<EmpVO> list = Arrays.asList(new EmpVO("홍길동", 100),
				new EmpVO("김기자", 50),
				new EmpVO("이순신", 150));
		
		// forEach 출력
		list.stream().forEach(System.out::println);
		
		// 이름만 출력
		Stream<EmpVO> stream = list.stream();
		stream.forEach(l -> System.out.println(l.getName()));
		
		// 급여순 정렬 출력
		list.stream().sorted((a,b) -> a.sal - b.sal).forEach(System.out::println);
		
		// 최대 급여사원의 이름
		// Optional -> null을 처리해줌
		Optional<EmpVO> result = list.stream().min(Comparator.comparing(EmpVO::getSal));
				//.orElse(EmpVO::new )
		
		System.out.println(result.get());
	}
}
