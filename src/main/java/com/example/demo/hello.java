package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class hello {
    @GetMapping("/hello")
    String index(Model model){
        model.addAttribute("username", "Guest");
        return "hello";
    }

    @GetMapping("/input")
    String input(){
        return "input";
    }
    @PostMapping("/output")
    String output(Article article){
        System.out.print("title: "+article.getTitle()+", content: "+article.getContent());
        return "output";
    }
}
