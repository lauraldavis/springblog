package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 60, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL) // posts.user_id // there are other cascade options
    @JsonBackReference
    private List<Post> posts;

    public User(){}

    // Copy constructor for authentication (login/logout)
    public User(User copy) { // A "copy" constructor required by many frameworks, not an alias reference or clone
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Post> getPosts() { return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }

}
