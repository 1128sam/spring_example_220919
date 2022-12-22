package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @RestController 아님에 주의. jsp에서는 @ResponseBody가 없어야 함
public class Lesson01Ex02Controller {

	// http://localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02() { // jsp로 return할때는 무조건 String으로 return
		// ResponseBody가 아닌 상태로 String을 return하면 
		// viewResolver에 의해 return된 String 이름의 view 경로를 찾고 화면이 구성된다.
		
		// 		/WEB-INF/jsp/(lesson01/ex02)/.jsp
		// return "/WEB-INF/jsp/lesson01/ex02.jsp";
		return "lesson01/ex02";
	}
}