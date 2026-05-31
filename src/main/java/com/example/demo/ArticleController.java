package com.example.demo;

import com.example.demo.DTO.Article_test;
import com.example.demo.Entity.Article;
import com.example.demo.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/")
    String index(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "index";
    }

    @GetMapping("/new")
    String input(){
        return "new";
    }

    @GetMapping("/view/{id}")
    String view(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "view";
    }

    @PostMapping("/save")
    String save(Article article){
        articleRepository.save(article);
        System.out.print("title: "+article.getTitle()+", content: "+article.getContent());
        return "index";
    }
    @GetMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "modify";
    }
    @PostMapping("/modify/{id}")
    String modified(@PathVariable Long id, Article article){
        System.out.println(article.getId());
        articleRepository.save(article);
        return "redirect:/view/"+id;
    }
    @GetMapping("/delete/{id}")
    String delete(@PathVariable Long id){
        articleRepository.deleteById(id);
        return "redirect:/";
    }
}
