package com.example.demo.controller;

import java.util.List;
import com.example.demo.binding.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/question") // Mapping at the class level
    public class QuestionController {

        @Autowired
        QuestionService questionService;

        @GetMapping("/allQuestions") // Mapping at the method level
        public ResponseEntity<List<Question>> getAllQuestions() {

            return questionService.getAllQuestion();
        }

        @GetMapping("/category/{category}")
        public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
            return questionService.getQuestionsByCategory(category);
        }

        @PostMapping("/add")
        public ResponseEntity<String> addQuestion(@RequestBody Question question){
            return questionService.addQuestion(question);

        }
}
