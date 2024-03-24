package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.binding.Question;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findQuestionsByCategory(String category);



    @Query(value="select * from Question q where q.category=:category order by Rand() limit :numQ ",nativeQuery=true)
    List<Question>  findRandomQuestionsByCategory(String category, int numQ);
}
