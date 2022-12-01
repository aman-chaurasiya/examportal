package com.examportal.services;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;

import javax.persistence.SecondaryTable;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

     public Question getQuestion(Long queId);

     public void deleteQue(Long queId);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);
 }
