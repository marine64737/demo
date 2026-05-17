package com.example.demo.Repository;

import com.example.demo.DTO.Article_test;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article_test, Long> {
}
