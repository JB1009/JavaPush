package com.example.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControllers {
	
	@GetMapping("/hello")
	public String callHomepage() {
		return "hello world~";
	}	
}

// 런타임과 컴파일 타임

// 개발자는 소스코드를 작성 후 컴파일이라는 과정을 통해 기계어코드(010101)
// 로 변환되어 실행 가능한 프로그램이 되며 , 이러한 과정을 컴파일타임(compile time)이라고 함

// 컴파일 과정을 마친 후 동작되어지는 때를
// 런타임이라고함

// 런타임 , 컴파일타임 오류

// - 런타임 오류 : 사칙연산오류 , 널참조 오류 , 메모리 부족 오류
// - 컴파일타임 오류 : 신택스오류 , 타입체크 오류
