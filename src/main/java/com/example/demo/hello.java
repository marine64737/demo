package com.example.demo;

import com.example.demo.DTO.Article_test;
import com.example.demo.Entity.Article;
import com.example.demo.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class hello {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/hello")
    String index(Model model){
        model.addAttribute("username", "Guest");
        return "hello";
    }

    @GetMapping("/input")
    String input(Model model){
        List<com.example.demo.Entity.Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "input";
    }

    @PostMapping("/output")
    String output(Article_test article_test){
        System.out.print("title: "+article_test.getTitle()+", content: "+article_test.getContent());
        return "output";
    }

    @PostMapping("/save")
    String save(Article article){
        articleRepository.save(article);
        System.out.print("title: "+article.getTitle()+", content: "+article.getContent());
        return "save";
    }
}
