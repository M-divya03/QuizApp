package com.example.demo.service;

import com.example.demo.binding.Question;
import com.example.demo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity(questionRepo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(questionRepo.findAll(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try {
            return new ResponseEntity(questionRepo.findQuestionsByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(questionRepo.findQuestionsByCategory(category), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            return new ResponseEntity(questionRepo.save(question), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(questionRepo.save(question), HttpStatus.BAD_REQUEST);
        }
      //return "SUCCESS";

            }
}
