package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// http://localhost:80/lesson03/ex01?id=2
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			// @RequestParam(value="id") int id // 필수 파라미터
			// @RequestParam(value="id", required=true) int id // required=true가 필수 파라미터라는 뜻
			// @RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			// @RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, default value가 1, null 가능하지만 null이라면 default value로
	) {
		
//		if (id == null) {
//			return null;
//		} else {
		return reviewBO.getReview(id);
//		}
	}
}