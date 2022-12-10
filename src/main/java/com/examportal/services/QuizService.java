package com.examportal.services;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuizById(Long qid);

    public void deleteQuiz(Long qid);


    List<Quiz> getQuizzesOfCategory(Category category);

}
