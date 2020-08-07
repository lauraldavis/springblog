package com.codeup.springblog.models;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String title;

    @Column(length = 255, nullable = false)
    private String body;

    @ManyToOne
//    @JsonManagedReference
    @JoinColumn (name = "user_id")
    private User author;

    public Post(){}

    // used when saving edited post
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    @Override
    public String toString() {
        return "Post{id=" + id + ",title='" + title + "', body='" + body + "'}";
    }

}
