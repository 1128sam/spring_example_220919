package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(int id); // @Param("id") => parameter가 하나면 필요없음

	public int insertReview(Review review);

	public int insertReviewAsField(@Param("storeId") int storeId, // 하나의 Map으로 구성됨
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);

	public int updateReviewById(@Param("id") int id, @Param("review") String review);

	public void deleteReviewById(int id);
}