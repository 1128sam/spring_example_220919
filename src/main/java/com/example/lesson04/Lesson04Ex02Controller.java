package com.example.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	// 학생 추가 화면
	// http://localhost:80/lesson04/ex02/add_student_view
	@GetMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}

	private StudentBO studentBO;
	@PostMapping("/add_student")
	public String addStudent( // name(request param)과 필드명이 일치하는 것이 담긴다.
			@ModelAttribute Student student,
			Model model
			) {

		// DB insert
		studentBO.addStudent(student);

		// DB select(방금 가입된 사람)
		System.out.println("student ID: " + student.getId());
		Student student1 = studentBO.getStudentById(student.getId());

		model.addAttribute("result", student1);
		model.addAttribute("subject", "학생 정보");

		// view 페이지 응답값(로 이동)
		return "lesson04/afterAddStudent";
	}
}