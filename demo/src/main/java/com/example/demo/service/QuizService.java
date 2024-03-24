package com.example.demo.service;

import com.example.demo.binding.Question;
import com.example.demo.binding.QuestionWrapper;
import com.example.demo.binding.Quiz;
import com.example.demo.repo.QuestionRepo;
import com.example.demo.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;


    public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);


        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> QuestionFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> QuestionsForUser=new ArrayList<>();
        for(Question q:QuestionFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),
                    q.getOption2(),q.getOption3(),q.getOption4());
            QuestionsForUser.add(qw);
        }

        return new ResponseEntity<>(QuestionsForUser,HttpStatus.OK);
    }
}
