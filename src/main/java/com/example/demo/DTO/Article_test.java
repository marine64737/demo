package com.example.demo.DTO;

public class Article_test {
    private String title;
    private String content;

    Article_test(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
}
