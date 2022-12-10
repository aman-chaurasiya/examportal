package com.examportal.controllers;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @GetMapping("/{qid}")
    public ResponseEntity<?> getQuiz(@PathVariable("qid")Long qid){
        return ResponseEntity.ok(this.quizService.getQuizById(qid));
    }

    @DeleteMapping("/{qid}")
    public void deleteQuizz(@PathVariable("qid")Long qid){
        this.quizService.deleteQuiz(qid);
    }


    @GetMapping("/category/{cid}")
    public ResponseEntity<?> getQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category= new Category();
        category.setId(cid);
        List<Quiz> quizzesOfCategory = this.quizService.getQuizzesOfCategory(category);
        return ResponseEntity.ok(quizzesOfCategory);
    }
}
