package com.examportal.repo;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
public List<Quiz> findBycategory(Category category);


}
