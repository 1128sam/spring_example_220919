package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson04/ex01")
@Controller
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	// BO를 여러 개 쓸 경우 @Autowired를 각자 붙여줘야 됨

	// 회원가입 화면
	// http://localhost:80/lesson04/ex01/add_user_view
	@RequestMapping(path="/add_user_view", method=RequestMethod.GET) // path= 는 생략 가능
	public String addUserView() {
		// /WEB-INF/jsp/(lesson04/addUser).jsp
		return "lesson04/addUser";
	}

	@PostMapping("/add_user") // /lesson04/ex01은 위에 써져있음
	public String addUser(
			@RequestParam("name") String name, 
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,			
			@RequestParam("introduce") String introduce) {
			// @RequestParam(value="introduce", required=false) String introduce => null(yes) 허용이면

		// DB insert
		userBO.addUser(name, yyyymmdd, introduce, email);

		return "lesson04/afterAddUser"; // 결과 jsp
	}
	
	// http://localhost:80/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUserView() {
		// db select
		

		return "lesson04/getLastUser";
	}
}

// ctrl + alt + h => call hierarchy(뭐가 뭐를 부르는지)