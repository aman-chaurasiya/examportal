package com.examportal.controllers;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.services.QuestionService;
import com.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService ;
    @Autowired
    private QuizService quizService;


    //add QUestion
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid")Long qid){


        Quiz quiz=this.quizService.getQuizById(qid);
        Set<Question> questions=quiz.getQuestions();
        List list=new ArrayList(questions);
        if (list.size()>Integer.parseInt(quiz.getNumberOfQuestion())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestion()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

        /*Quiz quiz = new Quiz();
        quiz.setQid(qid);

        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);*/
    }


    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid")Long qid){




        Quiz quiz = new Quiz();
        quiz.setId(qid);

        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);
    }

    //get single question

    @GetMapping("/{queId}")
    public Question get(@PathVariable("queId")Long queId){
        return this.questionService.getQuestion(queId);
    }

    //deletequestion

    @DeleteMapping("/{queId}")
    public void deleteQuestion (@PathVariable("queId")Long queId){
        this.questionService.deleteQue(queId);
    }


 }
