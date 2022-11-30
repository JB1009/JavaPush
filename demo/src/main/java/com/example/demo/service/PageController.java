package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/")
	public String callIndexPage() {
		return "index";
	}
	
	@GetMapping("/home")
	public String callHomePage() {
		return "home";
	}
	@GetMapping("/jb")
	public String callJBPage() {
		return "jongbin";

	}
	
//	@GetMapping("/movie")
//	public String callMovie(HttpServletRequest request) {
//		String ip = request.getRemoteAddr();
//		System.out.println("오청받은 IP : " + ip);
//		
//		return "movie";
//	}
//	
	@GetMapping("/login")
	public String callLogin() {
		return "login";
	}
	
	@GetMapping("/login2")
	public String callLogin2() {
		return "login2";
	}
	
	@GetMapping("/home2")
	public String callHome2() {
		return "home";
	}
	@GetMapping("/emp")
	public String callEmp() {
		return "emp";
	}
}
