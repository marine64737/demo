package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    Article(){}
    Article(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setTitle(String title){this.title=title;}
    public void setContent(String content){this.content=content;}
}
