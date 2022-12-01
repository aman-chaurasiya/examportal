package com.examportal.services.impl;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuestionRepository;
import com.examportal.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long queId) {
        return this.questionRepository.findById(queId).get();
    }

    @Override
    public void deleteQue(Long queId) {
        this.questionRepository.deleteById(queId);

    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }


}
