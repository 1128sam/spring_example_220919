package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;

	public Review getReview(int id) { // null일수 있는 경우 Integer로
		return reviewDAO.selectReview(id);
	}

	// input: Review 객체
	// output: int(인서트가 성공된 행 수)
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}

	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		// mysql에서 desc로 보면 null 허용, 그래서 double point 보다는 Double point가 더 정확함, 오류 줄일 듯

		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
}