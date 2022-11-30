package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.Login;
import com.example.demo.vo.Login2;
import com.example.demo.vo.Movie;


/*
 * RestController 와 Controller 차이점
 * 
 * Controller : 페이지 이동
 * 
 * RestController : 데이터 전송
 */
@RestController
public class ApiController {
	/*
	 * 클래스 이름 : 대문자로시작
	 * 변수 명 : 상수를 제외한 변수이름은 소문자
	 * 상수 : 대문자로 표기
	 * 함수이름 : 명사X 동사O function MakeDate O function Date X;
	 */
	
	
	@Autowired
	EmpDAO empDAO;
	
	@GetMapping("/api/v1/sample")
	public List<String> callData(){
		List <String> list = new ArrayList<String>();
		list.add("삼겹살");
		list.add("목살");
		list.add("오리고기");
		return list;
	}
	
	@GetMapping("/api/v1/movie")
	public Movie callMovie() {
		Movie movie = new Movie();

		movie.setTitle( "Just Friends");
		movie.setYear("2005");
		movie.setRuntime("95 min");
		movie.setGenre("Comedy, Romance");
		return movie;
	}
	
	@GetMapping("/api/v1/movies")
	public List<Movie> callMovies(){
		List<Movie> list = new ArrayList<Movie>();
		
		Movie movie = new Movie();
		System.out.println(movie);
		movie.setTitle( "Just Friends");
		movie.setYear("2005");
		movie.setRuntime("95 min");
		movie.setGenre("Comedy, Romance");
		
		Movie movie2 = new Movie();
		System.out.println(movie2);
		movie2.setTitle( "Just Friends");
		movie2.setYear("2005");
		movie2.setRuntime("95 min");
		movie2.setGenre("Comedy, Romance");
	
		list.add(movie);
		list.add(movie2);
		
		return list;
	}
	//Path : 주소로 데이터받기
	//Path + Variable;

	
	@GetMapping("/api/v1/sports/qatar2022/article/{articleNumber}")
	public int callArticle(@PathVariable int articleNumber) {
		return articleNumber;
	}
	
	///api/v1/webtoon/list?titleId=758037&weekday=mon
	
	@GetMapping("/api/v1/webtoon/list")
	public Map<String, Object> callWebtoon(@RequestParam int titleId,@RequestParam String weekday){
	
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);
		
		return map;
		
	}
	
	@GetMapping("/api/v1/webtoon/list/titleId/{titleId}/weekday/{weekday}")
	public Map<String, Object> callWebtoons(@PathVariable int titleId,@PathVariable String weekday){
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);
		
		return map;
	}
	
	
	@PostMapping("/api/v1/join")
	public boolean callJoin(@RequestBody Login login) {
		System.out.println("HTML에서 서버데이터 연동");
		System.out.println(login.getUserId());
		System.out.println(login.getUserPassword());
		System.out.println(login.getUserEmail());
		return true;
	}
	
	// GET : select == GET
	// POST : insert == POST
	// Patch : update == Patch
	// Delete : delete == Delete
	
	@PostMapping("/api/v1/join2")
	public boolean callJoin(@RequestBody Login2 login2) {
		
	
		System.out.println("HTML에서 서버데이터 연동");
		System.out.println("이름 : " + login2.getUserName());
		System.out.println("회사명 : " + login2.getCompanyName());
		System.out.println("연락처  : " + login2.getPhone());
		
		return true;
	}
	@GetMapping("/api/v1/emp")
	public List<EmpVO> callEmp(){
		
		return empDAO.selectEMP();
	
	}
	
	@GetMapping("/api/v1/dept")
	public List<DeptVO> callDept(){
		
		return empDAO.selectDEPT();
	
	}
	@PostMapping("/api/v1/emp/join")
	public int callEmpjoin(@RequestBody EmpVO emp) {
		return empDAO.insertEMP(emp);
	
	}
	
		
		

}
