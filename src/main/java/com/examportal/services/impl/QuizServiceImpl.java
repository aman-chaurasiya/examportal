package com.examportal.services.impl;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuizRepository;
import com.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuizById(Long qid) {
        return this.quizRepository.findById(qid).get();
    }

    @Override
    public void deleteQuiz(Long qid) {
        this.quizRepository.deleteById(qid);

    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {

        return this.quizRepository.findBycategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c,true);
    }
}
